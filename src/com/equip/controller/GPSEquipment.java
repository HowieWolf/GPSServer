package com.equip.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.equip.in.service.DataPackageService;
import com.equip.out.cmd.Command;
import com.equip.out.cmd.CommandFactory;
import com.equip.out.cmd.receive.BootCommand;
import com.equip.out.cmd.receive.DeviceInfoCommand;
import com.equip.out.cmd.receive.HeartCommand;
import com.equip.out.cmd.receive.PositionCommand;
import com.equip.out.io.CommandReceiver;
import com.equip.out.io.CommandSender;
import com.equip.out.io.impl.BufferedCommandReceiver;
import com.equip.out.io.impl.BufferedCommandSender;
import com.model.Equip;
import com.model.Position;
import com.model.Rail;

@Scope("prototype")
@Repository("gpsEquipment")
public class GPSEquipment extends Thread {

	private Socket socket;
	private CommandReceiver in;
	private CommandSender out;

	private CommandFactory factory;
	
	@Resource(name = "dataPackageService")
	private DataPackageService service;
	
	
	private Equip info;
	private ArrayList<Rail> rails;
	private boolean power;
	private Position lastPosition;

	File log;

	public GPSEquipment() {
		// TODO Auto-generated constructor stub
		factory = new CommandFactory();
		info = new Equip();
		rails = new ArrayList<>();
		lastPosition = new Position();
	}

	@Override
	public void run() {
		FileOutputStream fOut = null;
		fOut = createLog(fOut);

		SimpleDateFormat time = new SimpleDateFormat("yyyyMMddHHmmss");

		try {

			Command cmd = null;

			for (;;) {
				System.out.println("waiting for data!");
				cmd = factory.createCommand(in.readCommand());

				if (cmd.getDataType().equals(Command.POSITION)) {
					service.handlePosition((PositionCommand) cmd , lastPosition, rails);
				} else if (cmd.getDataType().equals(Command.HEART)) {
					service.handleHeart((HeartCommand) cmd);
				} else if (cmd.getDataType().equals(Command.BOOT)) {
					//this.power = true;
					this.info.setIMEI(cmd.getIMEI());
					service.handleBoot((BootCommand) cmd, this);
				} else if (cmd.getDataType().equals(Command.DEVICE_INFO)) {
					service.handleDeviceInfo((DeviceInfoCommand) cmd);
				} else {
					service.handleCommand(cmd);
				}

				String s = cmd + "----" + time.format(new Date());
				fOut.write((s + "\r\n").getBytes());
			}
		} catch (EOFException e) {
			/**
			 * 当读到数据末尾时，抛出该异常
			 */
			System.out.println("EOFException");
			e.printStackTrace();
		} catch (SocketException e) {
			/**
			 * 当客户端断开连接时，抛出该异常
			 */
			System.out.println("SocketException");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IOException");
			e.printStackTrace();
		} finally {
			service.handleDisconnection(info.getIMEI());
			//this.power = false;
			try {
				fOut.close();
				((BufferedOutputStream) out).close();
				((BufferedInputStream) in).close();
				System.out.println("close all stream");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void sendCommand(Command cmd) {
		try {
			out.writeCommand(cmd.toCommand());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getRemoteAddress(){
		return socket.getRemoteSocketAddress().toString();
	}

	private FileOutputStream createLog(FileOutputStream fOut) {
		try {
			log = new File("log.txt");
			if (!log.exists()) {
				log.createNewFile();
			}

			fOut = new FileOutputStream(log);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fOut;
	}

	public void addRail(Rail r){
		this.rails.add(r);
	}
	
	public ArrayList<Rail> getRails() {
		return rails;
	}

	public Equip getInfo() {
		return info;
	}
	
	public void setSocket(Socket socket) throws IOException {
		this.socket = socket;
		in = new BufferedCommandReceiver(socket.getInputStream());
		out = new BufferedCommandSender(socket.getOutputStream());
	}
}

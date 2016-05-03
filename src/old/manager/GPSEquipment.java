package old.manager;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;

import old.out.cmd.CommandReceiver;
import old.out.cmd.CommandSender;
import old.out.cmd.impl.BufferedCommandReceiver;
import old.out.cmd.impl.BufferedCommandSender;
import old.out.model.ReplyBootCommand;

public class GPSEquipment extends Thread {

	private EquipManager manager;
	
	private Socket socket;
	private CommandReceiver in;
	private CommandSender out;
	
	private String eId;

	File log;

	public GPSEquipment(Socket socket , EquipManager equips) throws IOException {
		this.socket = socket;
		this.manager = equips;
		/*
		 * System.out.println("服务器端口："+socket.getLocalPort());
		 * System.out.println("客户端端口："+socket.getPort());
		 * System.out.println("InetAddress："+socket.getInetAddress());
		 * System.out.println("RemoteAddress："+socket.getRemoteSocketAddress());
		 * System.out.println("LocalAddress："+socket.getLocalAddress());
		 */
		in = new BufferedCommandReceiver(socket.getInputStream());
		out = new BufferedCommandSender(socket.getOutputStream());
	}

	@Override
	public void run() {
		System.out.println("a equip has connected!");
		// TODO Auto-generated method stub
		FileOutputStream fOut = null;
		fOut = createLog(fOut);

		SimpleDateFormat time = new SimpleDateFormat("yyyyMMddHHmmss");

		try {

			/**
			 * 链接后第一条数据一定是开机数据包
			 */
			String cmd;
			String s;
			receiveAndReplyBootData(fOut, time);

			/**
			 * 接收正常的定位数据包和其他数据包
			 */
			for (;;) {
				System.out.println("waiting for data!");
				cmd = in.readCommand();
				s = cmd + "----" + time.format(new Date());
				System.out.println(s);
				fOut.write((s + "\r\n").getBytes());
			}
		} catch (EOFException e) {
			/**
			 * 当读到数据末尾时，抛出该异常
			 */
			System.out.println("EOFException");
		} catch (SocketException e) {
			/**
			 * 当客户端断开连接时，抛出该异常
			 */
			System.out.println("SocketException");
			manager.deleteEquip(this.eId);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IOException");
		}

		try {
			fOut.close();
			out.close();
			in.close();
			System.out.println("close all stream");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void receiveAndReplyBootData(FileOutputStream fOut, SimpleDateFormat time)
			throws EOFException, IOException {
		System.out.println("waiting for data!");
		String cmd = in.readCommand();
		String eId = cmd.split(",")[1];
		this.seteId(eId);
		manager.addEquip(this);
		String s = cmd + "----" + time.format(new Date());
		System.out.println(s);
		fOut.write((s + "\r\n").getBytes());

		out.writeCommand(new ReplyBootCommand().toString());
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

	public String geteId() {
		return eId;
	}

	public void seteId(String eId) {
		this.eId = eId;
	}

}

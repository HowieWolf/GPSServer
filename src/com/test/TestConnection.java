package com.test;

import java.io.IOException;
import java.net.Socket;

import com.equip.out.cmd.Command;
import com.equip.out.io.impl.BufferedCommandReceiver;
import com.equip.out.io.impl.BufferedCommandSender;

public class TestConnection {

	// public static final String HOST = "123.206.30.177";
	public static final String HOST = "localhost";

	public static final String[] CMD = {
			Command.DATA_START + Command.SEPARATOR_DATA
					+ "BOOT,867967020452449,17,20160426210303,460,01,1331,10679,89860112901300941700,92,,,,,CRCR"
					+ Command.SEPARATOR_DATA + Command.DATA_END,
			Command.DATA_START + Command.SEPARATOR_DATA
					+ "DEVICEINFO,867967020452449,18,iBabyGuardhttp,,201604151625,CRCR" + Command.SEPARATOR_DATA
					+ Command.DATA_END,
			Command.DATA_START + Command.SEPARATOR_DATA
					+ "POSITION,867967020452449,18,460,01,1331,10679,4,E11702.563500,N3914.475660,,99.99,65522,0,20160426210310,91,,,,,CRCR"
					+ Command.SEPARATOR_DATA + Command.DATA_END,
			Command.DATA_START + Command.SEPARATOR_DATA
					+ "POSITION,867967020452449,18,460,01,1331,10679,4,E11702.563500,N3914.475660,,99.99,65522,0,20160426210310,91,,,,,CRCR"
					+ Command.SEPARATOR_DATA + Command.DATA_END,
			Command.DATA_START + Command.SEPARATOR_DATA
					+ "POSITION,867967020452449,18,460,01,1331,10679,4,E11702.563500,N3914.475660,,99.99,65522,0,20160426210310,91,,,,,CRCR"
					+ Command.SEPARATOR_DATA + Command.DATA_END,
			Command.DATA_START + Command.SEPARATOR_DATA
					+ "HEART_D2S,867967020452449,19,VALID,NORMALPOWER,20160426210433,CRCR" + Command.SEPARATOR_DATA
					+ Command.DATA_END };

	public void run() {

		try {
			Socket socket = new Socket(HOST, 10000);
			BufferedCommandReceiver in = new BufferedCommandReceiver(socket.getInputStream());
			BufferedCommandSender out = new BufferedCommandSender(socket.getOutputStream());
			out.write(CMD[0].getBytes());
			out.flush();
			System.out.println(in.readCommand());
			System.out.println("data has been received");
			for (int i = 1; i < CMD.length; i++) {
				out.write(CMD[i].getBytes());
				out.flush();
				System.out.println("data has been sent");

				//Thread.sleep(2000);
			}


			out.close();
			in.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new TestConnection().run();
	}

}

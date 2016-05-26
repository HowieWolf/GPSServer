package com.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;

import com.equip.out.cmd.Command;
import com.equip.out.io.impl.BufferedCommandReceiver;
import com.equip.out.io.impl.BufferedCommandSender;

public class TestConnection extends Thread{

	//public static final String HOST = "123.206.30.177";
	public static final String HOST = "localhost";
	
	private String IMIE = "86796702045244";
	
	public String[] CMD = null;


	public TestConnection(int a){
		this.IMIE = this.IMIE + a;
		String[] CMD = {
				Command.DATA_START + Command.SEPARATOR_DATA
				+ "BOOT,"+IMIE+",17,20160426210303,460,01,1331,10679,89860112901300941700,92,,,,,CRCR"
				+ Command.SEPARATOR_DATA + Command.DATA_END,
				/*Command.DATA_START + Command.SEPARATOR_DATA
				+ "DEVICEINFO,"+IMIE+",18,iBabyGuardhttp,,201604151625,CRCR" + Command.SEPARATOR_DATA
				+ Command.DATA_END,*/
				Command.DATA_START + Command.SEPARATOR_DATA
				+ "POSITION,"+IMIE+",18,460,01,1331,10679,4,E11702.563500,N3914.475660,,99.99,65522,0,20160426211410,91,,,,,CRCR"
				+ Command.SEPARATOR_DATA + Command.DATA_END,
				Command.DATA_START + Command.SEPARATOR_DATA
				+ "POSITION,"+IMIE+",18,460,01,1331,10679,4,E11702.563500,N3914.475660,,99.99,65522,0,20160426211510,91,,,,,CRCR"
				+ Command.SEPARATOR_DATA + Command.DATA_END/*,
				Command.DATA_START + Command.SEPARATOR_DATA
				+ "POSITION,"+IMIE+",18,460,01,1331,10679,4,E11702.563500,N3914.475660,,99.99,65522,0,20160426211610,91,,,,,CRCR"
				+ Command.SEPARATOR_DATA + Command.DATA_END,
				Command.DATA_START + Command.SEPARATOR_DATA
				+ "HEART_D2S,"+IMIE+",19,VALID,NORMALPOWER,20160426210433,CRCR" + Command.SEPARATOR_DATA
				+ Command.DATA_END */};
		this.CMD = CMD;
	}
	
	@Override
	public void run() {
		BufferedCommandReceiver in = null;
		BufferedCommandSender out = null;
		Socket socket = null;
		try {
			socket = new Socket(HOST, 10000);
			in = new BufferedCommandReceiver(socket.getInputStream());
			out = new BufferedCommandSender(socket.getOutputStream());
			out.write(CMD[0].getBytes());
			out.flush();

			System.out.println(in.readCommand());
			System.out.println("data has been received");
			for (int i = 1; i < 5; i++) {
				out.write(CMD[i].getBytes());
				out.flush();
				System.out.println("data has been sent");
				Thread.sleep(5000);
			}

		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				((BufferedOutputStream)out).close();
				((BufferedInputStream)in).close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		for(int i = 9 ; i<10 ; i++){
			new TestConnection(i).start();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//test1();
	}

	private static void test1() {
		Socket socket = null;
		try {
			socket = new Socket(HOST,10000);
			Thread.sleep(5000);
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				socket.close();
				System.out.println("connection has closed!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

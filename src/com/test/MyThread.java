package com.test;

import java.io.IOException;
import java.net.ServerSocket;

public class MyThread extends Thread {

	ServerSocket server;
	
	public MyThread() {
		try {
			server = new ServerSocket(10000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		try {
			server.accept();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}

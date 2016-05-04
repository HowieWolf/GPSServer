package com.equip.manager;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketException;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.web.context.ContextLoader;

import com.equip.controller.GPSEquipment;

@Repository
public class GPSServer extends Thread {

	@Resource
	ServerSocket serverSocket;

	boolean working;

	@Override
	public void run() {
		System.out.println("EquipServer is running , waiting for equip!");
		while (working) {
			try {
				GPSEquipment equip = new GPSEquipment(serverSocket.accept());
				equip.start();
			} catch (SocketException e) {
				System.out.println("start");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("start");
				e.printStackTrace();
			}
		}
	}

	public void startServer() {
		this.start();
		this.working = true;
	}

	public void stopServer() {
		if (working) {
			this.working = false;
			try {
				serverSocket.close();
			} catch (IOException e) {
				System.out.println("stop");
				e.printStackTrace();
			}
			((EquipManager) ContextLoader.getCurrentWebApplicationContext().getBean("equipManager")).clear();
		}
	}

	public boolean isWorking() {
		return working;
	}

}

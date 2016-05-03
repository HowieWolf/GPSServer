package com.test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketException;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

@Repository
public class MyThread extends Thread {

	@Resource
	private ServerSocket serverSocket;

	public MyThread() {
		this.toString();
		System.out.println("MyThread Constructor----" + this.getId());
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("waiting for client---" + this.getId());
		try {
			serverSocket.accept();
			System.out.println("a client has been connected");
		} catch (SocketException e) {
			/**
			 * 当ServerSocket被关闭时，抛出该异常
			 */
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			
			try {
				serverSocket.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		System.out.println(super.toString() + "--------------" + this.getId());
		return super.toString();
	}

}

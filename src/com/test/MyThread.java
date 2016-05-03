package com.test;

import org.springframework.stereotype.Repository;

@Repository
public class MyThread extends Thread{

	public MyThread() {
		this.toString();
		System.out.println("MyThread Constructor----"+this.getId());
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.toString();
		System.out.println("MyThread.run----"+this.getId());
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		System.out.println(super.toString() +  "--------------" + this.getId());
		return super.toString();
	}
	
}

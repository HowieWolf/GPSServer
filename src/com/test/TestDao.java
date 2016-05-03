package com.test;

import org.springframework.stereotype.Repository;

@Repository
public class TestDao {

	public TestDao() {
		System.out.println("execute TestDao Constructor");
	}
	
	public void test(){
		System.out.println("select");
	}
	
}

package com.test;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@Resource
	private TestBean testBean;
	
	@Resource
	private TestDao testDao;
	
	@Resource
	private MyThread myThread;
	
	public TestController() {
		System.out.println("execute TestController constructor");
	}
	
	@RequestMapping("/start")
	public void start(){
		myThread.start();
	}
	
	@RequestMapping("/test")
	public void test(){
		myThread.toString();
	}
	
	
	public void setTestBean(TestBean testBean) {
		System.out.println("execute setTestBean");
		this.testBean = testBean;
	}
	
}

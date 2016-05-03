package com.test;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

@Controller
public class TestController {
	
	int i = 0;
	
	@Resource
	private MyThread myThread;
	
	public TestController() {
		System.out.println("execute TestController constructor");
	}
	
	@RequestMapping("/test")
	public void test(){
		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
		GPSEquipManager manager = (GPSEquipManager) wac.getBean("GPSEquipManager");
		
		System.out.println(manager.size());
		System.out.println(manager);
		
		manager.addEquip("" + i++, i+"");
		
	}
	
}

package com.equip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PowerController {

	@RequestMapping("/start")
	public void start(){
		System.out.println("启动设备服务器");
	}
	
	@RequestMapping("/stop")
	public void stop(){
		System.out.println("停止设备服务器");
	}
	
}

package com.equip.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.equip.manager.GPSServer;

@Controller
public class PowerController {

	@Resource
	GPSServer gpsServer;
	
	@RequestMapping("/start")
	public void start(){
		gpsServer.startServer();
		System.out.println("启动设备服务器");
	}
	
	@RequestMapping("/stop")
	public void stop(){
		gpsServer.stopServer();
		System.out.println("停止设备服务器");
	}
	
}

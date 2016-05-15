package com.equip.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.equip.manager.EquipManager;
import com.equip.manager.GPSServer;
import com.equip.out.cmd.reply.SetCommand;

@RequestMapping("/admin")
@Controller
public class AdminController {

	@Resource(name = "equipManager")
	EquipManager manager;

	@Resource
	GPSServer gpsServer;

	@RequestMapping("/start")
	public void start() {
		gpsServer.startServer();
		System.out.println("启动设备服务器");
		
	}

	@RequestMapping("/stop")
	public void stop() {
		gpsServer.stopServer();
		System.out.println("停止设备服务器");
	}

	@RequestMapping("/login")
	public String login(String pwd) {
		if (pwd.equals("112233")) {
			return "admin";
		} else {
			return "redirect:/";
		}
	}

	@RequestMapping("/iport")
	public void iport(String eId , String ip , String port){
		SetCommand cmd = new SetCommand();
		cmd.setIpAndPort(ip, port);
		manager.get(eId).sendCommand(cmd);
		System.out.println(cmd.toCommand());
	}
	
	@RequestMapping("/positionspan")
	public void positionSpan(String eId, int span) {
		SetCommand cmd = new SetCommand();
		cmd.setPositonSpan(span);
		manager.get(eId).sendCommand(cmd);
		System.out.println(cmd.toCommand());
	}

	@RequestMapping("/equiplist")
	public void equipList(HttpServletResponse res) throws IOException {
		PrintWriter writer = res.getWriter();
		if (manager.size() == 0) {
			writer.write("No Equipment!");
			return;
		}
		for (String key : manager.keySet()) {
			writer.write(manager.get(key).toString());
		}

	}

}

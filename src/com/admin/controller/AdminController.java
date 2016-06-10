package com.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.equip.controller.GPSEquipment;
import com.equip.manager.EquipManager;
import com.equip.manager.GPSServer;
import com.equip.out.cmd.reply.SetCommand;
import com.test.TestShowEquip;

@RequestMapping("/admin")
@Controller
public class AdminController {

	@Resource(name = "equipManager")
	EquipManager manager;

	@Resource
	GPSServer gpsServer;

	@RequestMapping("/start")
	public String start() {
		gpsServer.startServer();
		System.out.println("启动设备服务器");
		return "admin";
	}

	@RequestMapping("/stop")
	public String stop() {
		gpsServer.stopServer();
		System.out.println("停止设备服务器");
		return "admin";
	}

	@RequestMapping("/admin")
	public String index(HttpSession session) {
		Boolean isLogin = (Boolean) session.getAttribute("isLogin");
		if (isLogin != null && isLogin) {
			return "admin";
		}
		return "redirect:/";
	}
	
	@RequestMapping("/upload")
	public String upload(HttpSession session){
		Boolean isLogin = (Boolean) session.getAttribute("isLogin");
		if (isLogin != null && isLogin) {
			return "upload";
		}
		return "redirect:/";
	}

	@RequestMapping("/login")
	public String login(String pwd, HttpSession session) {
		if ("112233".equals(pwd)) {
			session.setAttribute("isLogin", true);
			return "admin";
		} else {
			return "redirect:/";
		}
	}

	@RequestMapping("/iport")
	public String iport(String eId, String ip, String port) {
		SetCommand cmd = new SetCommand();
		cmd.setIpAndPort(ip, port);
		manager.get(eId).sendCommand(cmd);
		System.out.println(cmd.toCommand());
		return "admin";
	}

	@RequestMapping("/positionspan")
	public String positionSpan(String eId, int span) {
		SetCommand cmd = new SetCommand();
		cmd.setPositonSpan(span);
		manager.get(eId).sendCommand(cmd);
		System.out.println(cmd.toCommand());
		return "admin";
	}

	@RequestMapping("/equiplist")
	public String equipList(HttpServletRequest req) throws IOException {
		List<TestShowEquip> equips = new ArrayList<>();
		for (Entry<String, GPSEquipment> a : manager.entrySet()) {
			GPSEquipment value = a.getValue();
			equips.add(new TestShowEquip(value.getInfo().getIMEI(), value.getRemoteAddress()));
		}

		req.setAttribute("equips", equips);
		return "equipList";
	}

}

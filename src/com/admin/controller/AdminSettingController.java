package com.admin.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.equip.manager.EquipManager;
import com.equip.out.cmd.reply.SetCommand;

@RequestMapping("/admin/setting")
@Controller
public class AdminSettingController {
	
	@Resource(name = "equipManager")
	EquipManager manager;
	
	@RequestMapping("/iport")
	public String iport(String eId, String ip, String port) {
		SetCommand cmd = new SetCommand();
		cmd.setIpAndPort(ip, port);
		manager.get(eId).sendCommand(cmd);
		System.out.println(cmd.toCommand());
		return "setting";
	}

	@RequestMapping("/positionspan")
	public String positionSpan(String eId, int span) {
		SetCommand cmd = new SetCommand();
		cmd.setPositonSpan(span);
		manager.get(eId).sendCommand(cmd);
		System.out.println(cmd.toCommand());
		return "setting";
	}

}

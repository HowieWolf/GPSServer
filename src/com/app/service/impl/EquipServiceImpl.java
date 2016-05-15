package com.app.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.app.service.EquipService;
import com.equip.controller.GPSEquipment;
import com.equip.manager.EquipManager;
import com.equip.out.cmd.reply.AlertCommand;
import com.equip.out.cmd.reply.SendMessageCommand;

@Service("equipService")
public class EquipServiceImpl implements EquipService{

	@Resource(name = "equipManager")
	private EquipManager manager;
	
	@Override
	public void handleAlertMedicine(String eId) {
		// TODO Auto-generated method stub
		GPSEquipment equip = manager.getEquip(eId);
		equip.sendCommand(new AlertCommand(eId));
	}

	@Override
	public void handleAwaySecurity(String eId) {
		// TODO Auto-generated method stub
		String msg = "SOS";
		String phone = "15302098366";
		GPSEquipment equip = manager.getEquip(eId);
		equip.sendCommand(new AlertCommand(eId));
		equip.sendCommand(new SendMessageCommand(phone , msg));
	}

}

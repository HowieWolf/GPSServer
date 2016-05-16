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
	public boolean handleAlertMedicine(String eId) {
		// TODO Auto-generated method stub
		GPSEquipment equip = manager.getEquip(eId);
		if(equip == null){
			return false;
		}
		AlertCommand cmd = new AlertCommand(eId);
		equip.sendCommand(cmd);
		System.out.println("向"+eId+"发出警报信号！");
		System.out.println(cmd.toCommand());
		return true;
	}

	/**
	 * 这个方法是测试阶段，世界不应该有phone参数
	 */
	public boolean handleAwaySecurity(String eId , String phone){
		String msg = "SOS";
		GPSEquipment equip = manager.getEquip(eId);
		if(equip == null){
			return false;
		}
		equip.sendCommand(new AlertCommand(eId));
		SendMessageCommand cmd = new SendMessageCommand(phone , msg);
		equip.sendCommand(cmd);
		System.out.println("向"+eId+"发出给"+phone+"发送短信["+msg+"]的信号！");
		System.out.println(cmd.toCommand());
		return true;
	}
	
	@Override
	public boolean handleAwaySecurity(String eId) {
		// TODO Auto-generated method stub
		String msg = "SOS";
		String phone = "15302098366";
		GPSEquipment equip = manager.getEquip(eId);
		if(equip == null){
			return false;
		}
		equip.sendCommand(new AlertCommand(eId));
		SendMessageCommand cmd = new SendMessageCommand(phone , msg);
		equip.sendCommand(cmd);
		System.out.println("向"+eId+"发出给"+phone+"发送短信["+msg+"]的信号！");
		System.out.println(cmd.toCommand());
		return true;
	}

}

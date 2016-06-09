package com.equip.in.service.impl;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.EquipmentDao;
import com.dao.PositionDao;
import com.dao.RailDao;
import com.equip.controller.GPSEquipment;
import com.equip.in.service.DataPackageService;
import com.equip.manager.EquipManager;
import com.equip.out.cmd.Command;
import com.equip.out.cmd.receive.BootCommand;
import com.equip.out.cmd.receive.DeviceInfoCommand;
import com.equip.out.cmd.receive.HeartCommand;
import com.equip.out.cmd.receive.PositionCommand;
import com.equip.out.cmd.reply.ReplyBootCommand;
import com.model.Equip;
import com.model.Position;
import com.model.Rail;

@Service("dataPackageService")
public class DataPackageServiceImpl implements DataPackageService {

	@Resource
	EquipManager manager;

	@Resource
	PositionDao positionDao;

	@Resource
	EquipmentDao equipmentDao;

	@Resource
	RailDao railDao;
	
	@Override
	public void handleCommand(Command cmd) {
		System.out.println("未处理" + cmd.toCommand());
	}

	@Override
	public void handlePosition(PositionCommand posCmd ,Position lastPosition, List<Rail>rails) {
		Position pos = new Position(posCmd);

		if (!lastPosition.isTheSameLocationAs(pos)) {
			for (Rail r : rails) {
				if (r.isAwayRail(pos.getLat(), pos.getLng())) {
					pos.setInRail(false);
					break;
				}
			}
			positionDao.addPosition(pos);
			lastPosition.setId(pos.getId());
			lastPosition.setLat(pos.getLat());
			lastPosition.setLng(pos.getLng());
			lastPosition.setInRail(pos.isInRail());
			lastPosition.setTime(pos.getTime());
		} else {
			lastPosition.setTime(pos.getTime());
			positionDao.updatePosition(lastPosition);
		}

		System.out.println("handlePosition-->" + posCmd);
	}

	@Override
	public void handleDeviceInfo(DeviceInfoCommand cmd) {
		System.out.println("handleDeviceInfo-->" + cmd);
	}

	@Override
	public void handleBoot(BootCommand cmd, GPSEquipment equip) throws IOException {
		System.out.println("handBoot-->" + cmd);
		ReplyBootCommand reply = new ReplyBootCommand();
		equip.sendCommand(reply);
		// 交给设备管理器，存放到容器中
		manager.addEquip(equip);
		Equip e = equipmentDao.queryEquipByIMEI(equip.getInfo().getIMEI());
		if (e == null) {
			equipmentDao.addEquip(equip.getInfo());
		} else {
			equip.getInfo().setPhone(e.getPhone());
			equip.getRails().clear();
			equip.getRails().addAll(railDao.queryRails(equip.getInfo().getIMEI()));
		}
	}

	@Override
	public void handleHeart(HeartCommand cmd) {
		System.out.println("handleHeart-->" + cmd);
	}

	@Override
	public void handleDisconnection(String imei) {
		// TODO Auto-generated method stub
		manager.deleteEquip(imei);
	}

}

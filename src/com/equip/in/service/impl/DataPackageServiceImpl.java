package com.equip.in.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.EquipmentDao;
import com.dao.PositionDao;
import com.dao.RailDao;
import com.equip.in.service.DataPackageService;
import com.equip.out.cmd.Command;
import com.equip.out.cmd.receive.BootCommand;
import com.equip.out.cmd.receive.DeviceInfoCommand;
import com.equip.out.cmd.receive.HeartCommand;
import com.equip.out.cmd.receive.PositionCommand;
import com.equip.out.cmd.reply.ReplyBootCommand;
import com.equip.out.io.CommandSender;
import com.model.Equipment;
import com.model.Position;
import com.model.Rail;

@Service("dataPackageService")
public class DataPackageServiceImpl implements DataPackageService {

	@Resource
	PositionDao positionDao;

	@Resource
	EquipmentDao equipmentDao;

	@Resource
	RailDao railDao;

	Position lastPosition;

	@Override
	public void handleCommand(Command cmd) {
		System.out.println("未处理" + cmd.toCommand());
	}

	@Override
	public void handlePosition(PositionCommand posCmd, List<Rail> rails) {
		Position pos = new Position(posCmd);
		for (Rail r : rails) {
			if (r.isAwayRail(pos.getLat(), pos.getLng())) {
				pos.setInRail(false);
				break;
			}
		}

		if (lastPosition == null || !lastPosition.isTheSameLocationAs(pos)) {
			lastPosition = pos;
			positionDao.addPosition(lastPosition);
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
	public void handleBoot(BootCommand cmd, CommandSender sender, Equipment equip, ArrayList<Rail> rails)
			throws IOException {
		System.out.println("handBoot-->" + cmd);
		String reply = new ReplyBootCommand().toCommand();
		sender.writeCommand(reply);

		Equipment e = equipmentDao.queryEquipById(equip.getId());
		if (e == null) {
			equipmentDao.addEquip(equip);
		} else {
			equip.setName(e.getName());
			equip.setPhone(e.getPhone());
			equip.setuId(e.getuId());
			rails.clear();
			rails.addAll(railDao.queryRails(equip.getId()));
		}
	}

	@Override
	public void handleHeart(HeartCommand cmd) {
		System.out.println("handleHeart-->" + cmd);
	}

}

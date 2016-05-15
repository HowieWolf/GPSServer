package com.equip.in.service.impl;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.PositionDao;
import com.equip.in.service.DataPackageService;
import com.equip.manager.EquipManager;
import com.equip.out.cmd.Command;
import com.equip.out.cmd.receive.BootCommand;
import com.equip.out.cmd.receive.DeviceInfoCommand;
import com.equip.out.cmd.receive.HeartCommand;
import com.equip.out.cmd.receive.PositionCommand;
import com.equip.out.cmd.reply.ReplyBootCommand;
import com.equip.out.io.CommandSender;
import com.model.Position;

@Service("dataPackageService")
public class DataPackageServiceImpl implements DataPackageService {

	@Resource
	PositionDao positionDao;

	@Override
	public void handleCommand(Command cmd) {
		System.out.println("未处理"+cmd.toCommand());
	}

	@Override
	public void handlePosition(PositionCommand posCmd) {
		Position pos = new Position(posCmd);
		positionDao.addPosition(pos);
		System.out.println("handlePosition-->" + posCmd);
	}

	@Override
	public void handleDeviceInfo(DeviceInfoCommand cmd) {
		System.out.println("handleDeviceInfo-->" + cmd);
	}

	@Override
	public void handleBoot(BootCommand cmd, CommandSender sender) throws IOException {
		System.out.println("handBoot-->" + cmd);
		String reply = new ReplyBootCommand().toCommand();
		sender.writeCommand(reply);
	}

	@Override
	public void handleHeart(HeartCommand cmd) {
		System.out.println("handleHeart-->" + cmd);
	}

}

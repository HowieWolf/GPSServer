package com.equip.in.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.PositionDao;
import com.equip.in.service.DataPackageService;
import com.equip.out.cmd.Command;
import com.equip.out.cmd.receive.BootCommand;
import com.equip.out.cmd.receive.DeviceInfoCommand;
import com.equip.out.cmd.receive.HeartCommand;
import com.equip.out.cmd.receive.PositionCommand;
import com.model.Position;

@Service("dataPackageService")
public class DataPackageServiceImpl implements DataPackageService {

	@Resource
	PositionDao positionDao;
	
	@Override
	public void handleDataPackage(Command cmd) {
		// TODO Auto-generated method stub
		if (cmd.getDataType().equals(Command.POSITION)) {
			handlePosition((PositionCommand) cmd);
		} else if (cmd.getDataType().equals(Command.HEART)) {
			handleHeart((HeartCommand) cmd);
		} else if (cmd.getDataType().equals(Command.BOOT)) {
			handBoot((BootCommand) cmd);
		} else if (cmd.getDataType().equals(Command.DEVICE_INFO)) {
			handleDeviceInfo((DeviceInfoCommand) cmd);
		}
	}

	private void handlePosition(PositionCommand posCmd) {
		Position pos = new Position(posCmd);
		positionDao.addPosition(pos);
		System.out.println("handlePosition-->"+posCmd);
	}

	private void handleDeviceInfo(DeviceInfoCommand cmd) {
		System.out.println("handleDeviceInfo-->"+cmd);
	}

	private void handBoot(BootCommand cmd) {
		System.out.println("handBoot-->"+cmd);
	}

	private void handleHeart(HeartCommand cmd) {
		System.out.println("handleHeart-->"+cmd);
	}
	
	public void logDataPackae(Command cmd){
		
	}

}

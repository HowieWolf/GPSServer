package com.equip.in.service;

import java.io.IOException;

import com.equip.out.cmd.Command;
import com.equip.out.cmd.receive.BootCommand;
import com.equip.out.cmd.receive.DeviceInfoCommand;
import com.equip.out.cmd.receive.HeartCommand;
import com.equip.out.cmd.receive.PositionCommand;
import com.equip.out.io.CommandSender;

public interface DataPackageService {

	public void handleCommand(Command cmd);
	public void handleBoot(BootCommand cmd, CommandSender sender) throws IOException;
	public void handleDeviceInfo(DeviceInfoCommand cmd);
	public void handleHeart(HeartCommand cmd);
	public void handlePosition(PositionCommand cmd);
	
}

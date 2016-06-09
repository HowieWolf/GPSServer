package com.equip.in.service;

import java.io.IOException;
import java.util.List;

import com.equip.controller.GPSEquipment;
import com.equip.out.cmd.Command;
import com.equip.out.cmd.receive.BootCommand;
import com.equip.out.cmd.receive.DeviceInfoCommand;
import com.equip.out.cmd.receive.HeartCommand;
import com.equip.out.cmd.receive.PositionCommand;
import com.model.Position;
import com.model.Rail;

public interface DataPackageService {

	public void handleCommand(Command cmd);

	public void handleBoot(BootCommand cmd, GPSEquipment equip) throws IOException;

	public void handleDeviceInfo(DeviceInfoCommand cmd);

	public void handleHeart(HeartCommand cmd);

	public void handlePosition(PositionCommand posCmd, Position position, List<Rail> rails);

	public void handleDisconnection(String imei);

}

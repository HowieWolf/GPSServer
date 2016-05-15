package com.equip.out.cmd.receive;

import com.equip.out.cmd.Command;

public class DeviceInfoCommand extends Command {

	public DeviceInfoCommand(String cmd) {
		this.dataType = Command.DEVICE_INFO;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "设备信息";
	}
}

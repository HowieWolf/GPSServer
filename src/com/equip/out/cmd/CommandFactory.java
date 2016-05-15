package com.equip.out.cmd;

import com.equip.out.cmd.receive.BootCommand;
import com.equip.out.cmd.receive.DeviceInfoCommand;
import com.equip.out.cmd.receive.HeartCommand;
import com.equip.out.cmd.receive.PositionCommand;

public class CommandFactory {

	public Command createCommand(String cmd) {
		Command command = null;
		if (cmd.startsWith(Command.POSITION)) {
			command = new PositionCommand(cmd);
		} else if (cmd.startsWith(Command.HEART)) {
			command = new HeartCommand(cmd);
		} else if (cmd.startsWith(Command.BOOT)) {
			command = new BootCommand(cmd);
		} else if (cmd.startsWith(Command.DEVICE_INFO)) {
			command = new DeviceInfoCommand(cmd);
		} else{
			command = new Command(cmd);
		}
		return command;
	}

}

package com.equip.out.cmd;

public class CommandFactory {

	public static Command createCommand(String cmd) {
		Command command = null;
		if (cmd.startsWith(Command.POSITION)) {
			command = new PositionCommand(cmd);
		} else if (cmd.startsWith(Command.HEART)) {

		} else if (cmd.startsWith(Command.BOOT)) {
			command = new BootCommand(cmd);
		} else if (cmd.startsWith(Command.DEVICE_INFO)) {
			command = new DeviceInfoCommand(cmd);
		} else if (cmd.startsWith(Command.HEART)) {

		}
		return command;
	}

}

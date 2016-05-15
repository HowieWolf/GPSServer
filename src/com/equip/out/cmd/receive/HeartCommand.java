package com.equip.out.cmd.receive;

import com.equip.out.cmd.Command;

public class HeartCommand extends Command{

	public HeartCommand(String cmd) {
		// TODO Auto-generated constructor stub
		this.dataType = Command.HEART;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "心跳";
	}
	
}

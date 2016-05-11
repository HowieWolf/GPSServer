package com.equip.out.cmd;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReplyBootCommand extends Command {

	public ReplyBootCommand() {
		// TODO Auto-generated constructor stub
		this.time = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String reply = Command.DATA_START + Command.SEPARATOR_DATA + Command.REPLY_BOOT + "," + this.time + ","
				+ "CRCR" + Command.SEPARATOR_DATA + Command.DATA_END;
		return reply;
	}

}

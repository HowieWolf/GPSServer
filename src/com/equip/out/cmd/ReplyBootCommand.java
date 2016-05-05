package com.equip.out.cmd;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReplyBootCommand extends Command {

	public ReplyBootCommand() {
		// TODO Auto-generated constructor stub
		this.dateTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String reply = Command.DATA_START + "," + Command.REPLY_BOOT + "," + this.dateTime + ","
				+ this.CRC + "," + Command.DATA_END;
		return reply;
	}

}

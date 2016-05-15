package com.equip.out.cmd.reply;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.equip.out.cmd.Command;

public class ReplyBootCommand extends Command {

	public ReplyBootCommand() {
		// TODO Auto-generated constructor stub
		this.dataType = Command.REPLY_BOOT;
		//this.IMEI="";
		this.time = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	}

	@Override
	public String toCommand() {
		setContent(this.time);
		return super.toCommand();
	}

}

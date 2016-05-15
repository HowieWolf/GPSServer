package com.equip.out.cmd.reply;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.equip.out.cmd.Command;

public class AlertCommand extends Command {

	public AlertCommand(String imei) {
		// TODO Auto-generated constructor stub
		this.dataType = Command.ALERT;
		this.IMEI = imei;
		this.time = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	}

	@Override
	public String toCommand() {
		// TODO Auto-generated method stub
		setContent(0 +Command.SEPARATOR_DATA+ this.time);
		return super.toCommand();
	}

}

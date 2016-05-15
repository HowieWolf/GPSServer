package com.equip.out.cmd.reply;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.equip.out.cmd.Command;

public class SendMessageCommand extends Command {

	private String phone;
	private String msg;

	public SendMessageCommand(String phone , String msg) {
		// TODO Auto-generated constructor stub
		this.dataType = Command.SEND_MESSAGE;
		this.time = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		this.phone = phone;
		this.msg = stringToUnicode(msg);
	}

	@Override
	public String toCommand() {
		// TODO Auto-generated method stub
		setContent(this.phone + Command.SEPARATOR_DATA + this.msg);
		return super.toCommand();
	}

	public String stringToUnicode(String string) {
		String unicode = "";
		for (int i = 0; i < string.length(); i++) {
			int ch = (int) string.charAt(i);
			unicode += Integer.toHexString(ch).toUpperCase();
		}
		return unicode;
	}

}

package com.equip.out.cmd.reply;

import com.equip.out.cmd.Command;

public class SetCommand extends Command{

	//DATASTART,SET,SERVERIP=1.1.1.1#SERVERPORT=9900,CRCR,DATAEND
	
	public SetCommand() {
		// TODO Auto-generated constructor stub
		this.dataType = Command.SET;
	}
	
	public void setIpAndPort(String ip , String port){
		this.content = "SERVER_IP="+ip+Command.SEPARATOR_ARG+"SERVER_PORT="+port;
	}
	
	public void setPositonSpan(int span){
		this.content = "POSITION_TIMESPAN="+span;
	}
	
	@Override
	public String toCommand() {
		// TODO Auto-generated method stub
		return super.toCommand();
	}
	
}

package com.equip.out.cmd;

public class Command {

	// 表示从DATASTART开始到DATAEND之间最短指令长度
	public static final int MIN_LENGTH = 60;

	/**
	 * 数据包的开始结束标志
	 */
	public static final String DATA_START = "DATASTART";
	public static final String DATA_END = "DATAEND";

	/**
	 * 数据包分隔符,数据项分隔符和查询参数分隔符
	 */
	public static final String SEPARATOR_DATA = ",";
	public static final String SEPARATOR_ARG = "#";

	/**
	 * 数据包类型
	 */
	public static final String BOOT = "BOOT";
	public static final String POSITION = "POSITION";
	public static final String DEVICE_INFO = "DEVICEINFO";
	public static final String HEART = "HEART_D2S";
	public static final String REPLY_BOOT = "REPLYBOOT";
	public static final String ALERT = "ALERT_S2D";
	public static final String SEND_MESSAGE = "SENDMSM";
	public static final String SET = "SET";
	public static final String GET = "GET";

	protected String dataType;
	protected String IMEI;
	protected String time;
	protected String content = "";
	protected String CRC = "CRCR";

	public Command() {}
	
	public Command(String cmd){
		String[] s = cmd.split(",");
		this.dataType=s[0];
		this.IMEI = s[1];
		this.CRC=s[s.length-1];
		this.content = cmd.substring(this.dataType.length()+this.IMEI.length()+2, cmd.length()-this.CRC.length()-1);
	}
	
	public String toCommand() {
		StringBuffer cmd = new StringBuffer(
				Command.DATA_START + Command.SEPARATOR_DATA + this.dataType + Command.SEPARATOR_DATA);
		if (this.IMEI == null || this.IMEI.length() == 0) {

		} else {
			cmd.append(this.IMEI + Command.SEPARATOR_DATA);
		}
		return cmd.append(this.content + Command.SEPARATOR_DATA + this.CRC + Command.SEPARATOR_DATA + Command.DATA_END)
				.toString();
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getIMEI() {
		return IMEI;
	}

	public void setIMEI(String iMEI) {
		IMEI = iMEI;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getCRC() {
		return CRC;
	}

	public void setCRC(String cRC) {
		CRC = cRC;
	}

}

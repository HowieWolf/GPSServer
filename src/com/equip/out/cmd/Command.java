package com.equip.out.cmd;

public class Command {
	
	//表示从DATASTART开始到DATAEND之间最短指令长度
	public static final int MIN_LENGTH = 60;
	
	/**
	 * 数据包的开始结束标志
	 */
	public static final String DATA_START="DATASTART";
	public static final String DATA_END="DATAEND";
	
	/**
	 * 数据包分隔符,数据项分隔符和查询参数分隔符
	 */
	public static final String SEPARATOR_DATA = ",";
	public static final String SEPARATOR_ARG = "#";
	
	/**
	 * 数据包类型
	 */
	public static final String BOOT="BOOT";
	public static final String POSITION="POSITION";
	public static final String DEVICE_INFO="DEVICEINFO";
	public static final String HEART="HEART_D2S";
	public static final String REPLY_BOOT="REPLYBOOT";
	
	
	protected String dataType;
	protected String IMEI;
	protected String time;
	protected String CRC;
	
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

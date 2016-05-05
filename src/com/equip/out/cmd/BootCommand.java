package com.equip.out.cmd;

public class BootCommand extends Command {

	// MCC(Mobile Country Code)移动国家码 中国：460
	protected int MCC;
	/**
	 * MNC(Mobile Network Code)移动网络码 中国移动：00，02，07 中国联通：01，06
	 */
	protected int MNC;
	// CI（Cell Identity）：范围为0～65535。
	protected int CI;
	// LAC(location area code)位置区码 范围[0000,FFFF]十六进制
	protected int LAC;
	// ICCID(Integrate circuit card identity)集成电路卡识别码 手机卡编码,20位
	protected String ICCID;

	// 电池电量
	protected int battery;

	protected String remark1;
	protected String remark2;
	protected String remark3;
	protected String remark4;

	// 数据类型，设备标识，数据索引，当前时间，MCC，MNC，LAC，CellID，ICCID，电池电量，remark1，remark2，remark3，remark4，CRC，
	public BootCommand(String cmd) {
		String[] datas = cmd.split(",");

		this.dataType = Command.BOOT;
		this.IMEI = datas[1];
		this.dateTime = datas[3];
		this.MCC = Integer.parseInt(datas[4]);
		this.MNC = Integer.parseInt(datas[5]);
		this.LAC = Integer.parseInt(datas[6]);
		this.CI = Integer.parseInt(datas[7]);
		this.ICCID = datas[8];
		this.battery = Integer.parseInt(datas[9]);
		this.CRC = datas[14];
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public int getMCC() {
		return MCC;
	}

	public void setMCC(int mCC) {
		MCC = mCC;
	}

	public int getMNC() {
		return MNC;
	}

	public void setMNC(int mNC) {
		MNC = mNC;
	}

	public int getCI() {
		return CI;
	}

	public void setCI(int cI) {
		CI = cI;
	}

	public int getLAC() {
		return LAC;
	}

	public void setLAC(int lAC) {
		LAC = lAC;
	}

	public String getICCID() {
		return ICCID;
	}

	public void setICCID(String iCCID) {
		ICCID = iCCID;
	}

	public int getBattery() {
		return battery;
	}

	public void setBattery(int battery) {
		this.battery = battery;
	}

	public String getRemark1() {
		return remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public String getRemark2() {
		return remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	public String getRemark3() {
		return remark3;
	}

	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}

	public String getRemark4() {
		return remark4;
	}

	public void setRemark4(String remark4) {
		this.remark4 = remark4;
	}
}

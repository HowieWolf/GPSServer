package com.equip.out.cmd.receive;

import com.equip.out.cmd.Command;

public class PositionCommand extends Command {

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

	// 定位性质：0，开机定位。1，实时GPS 定位。2，补传。3，GPS 定位失败，GPS 数据位空字符。4，当GPS 未定位，GSM基站定位
	protected int locateType;

	public static final int LOCATE_BOOT = 0;
	public static final int LOCATE_GPS = 1;
	public static final int LOCATE_SUPPLY = 2;
	public static final int LOCATE_FAIL = 3;
	public static final int LOCATE_GSM = 4;

	//handlePosition-->定位[ID:867967020135929][开机定位][经度：11703.0287][纬度：3913.9951]
	//handlePosition-->定位[ID:867521029813968][GSM][经度：11702.5635][纬度：3914.47566]
	//handlePosition-->定位[ID:867967020135929][GPS][经度：11703.0355][纬度：3913.9991]
	
	private String[] locate = { "开机定位", "GPS", "补传", "未定位", "GSM" };

	// 经纬度
	protected double lng;
	protected double lat;
	// 海拔
	protected double alititude;
	// 精度
	protected double accuracy;
	// 方位角
	protected double course;
	// 速度
	protected double speed;

	// 电池电量
	protected int battery;

	protected String remark1;
	protected String remark2;
	protected String remark3;
	protected String remark4;

	public PositionCommand(String cmd) {
		// 数据类型，设备标识，MCC,MNC,LAC,Cell ID，定位性质，Lng,
		// Lat,alititude,accuracy,Course,Speed,Time，电量百分比，remark1，remark2，remark3，remark4，CRC校验，数据结束
		// ,,99.99,65522,0,20160426210310,91,,,,,CRCR----20160426210313
		String[] datas = cmd.split(",");
		this.dataType = Command.POSITION;
		this.IMEI = datas[1];
		this.MCC = Integer.parseInt(datas[3]);
		this.MNC = Integer.parseInt(datas[4]);
		this.LAC = Integer.parseInt(datas[5]);
		this.CI = Integer.parseInt(datas[6]);
		this.locateType = Integer.parseInt(datas[7]);
		//this.lng = Double.parseDouble(datas[8].substring(1));
		//this.lat = Double.parseDouble(datas[9].substring(1));
		this.lng = formateLngAndLat(datas[8]);
		this.lat = formateLngAndLat(datas[9]);
		// 海拔、速度、精度等尚未设置
		// 其中某个参数可能为空
		this.speed = 0;
		this.time = datas[14];
		this.battery = Integer.parseInt(datas[15]);
		this.CRC = datas[20];
	}

	public double formateLngAndLat(String arg) {
		// 如果尚未定位，则返回0
		if (arg==null || arg.isEmpty() || arg.equals("EWX") || arg.equals("NSX")) {
			return 0;
		}
		double l = 0;
		int d = 0;
		double m = 0;
		int index = arg.indexOf(".")-2;
		d = Integer.parseInt(arg.substring(1, index));
		m = Double.parseDouble(arg.substring(index));
		l = d + m / 60;
		return l;
	}

	@Override
	public String toString() {
		String cmd = "定位[ID:" + this.IMEI + "][时间：" + this.time + "][电量：" + this.battery + "][定位类型："
				+ locate[this.locateType] + "][经度：" + this.lng + "][纬度：" + this.lat + "]";
		return cmd;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public int getBattery() {
		return battery;
	}

	public void setBattery(int battery) {
		this.battery = battery;
	}

	public double getSpeed() {
		return speed;
	}

}

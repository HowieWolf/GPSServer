package com.model;

/**
 * 用户添加设备的记录
 * @author HowieWang
 *
 */
public class Equipment {

	/**
	 * id是添加记录的id，唯一标识了某用户添加了某一设备
	 * eId是设备IMEI
	 * uId是用户id
	 * name是昵称字段
	 */
	private int id;
	private String eId;
	private String name;
	private int uId;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String geteId() {
		return eId;
	}

	public void seteId(String eId) {
		this.eId = eId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

}

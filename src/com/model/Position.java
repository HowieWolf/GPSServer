package com.model;

import com.equip.out.cmd.PositionCommand;

public class Position {
	
	private int id;
	private String time;
	private double lat;
	private double lng;
	private double speed;
	private String eId;
	
	public Position() {}
	
	public Position(PositionCommand posCmd) {
		this.time = posCmd.getTime();
		this.lat = posCmd.getLat();
		this.lng = posCmd.getLng();
		this.speed = posCmd.getSpeed();
		this.eId = posCmd.getIMEI();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public String geteId() {
		return eId;
	}

	public void seteId(String eId) {
		this.eId = eId;
	}
	
	

}

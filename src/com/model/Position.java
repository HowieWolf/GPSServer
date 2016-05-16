package com.model;

import com.equip.out.cmd.receive.PositionCommand;

public class Position {

	private int id;
	private String time;
	private double lat;
	private double lng;
	private double speed;
	private String eId;
	private boolean inRail = true;

	public Position() {
	}

	public Position(PositionCommand posCmd) {
		this.time = posCmd.getTime();
		this.lat = posCmd.getLat();
		this.lng = posCmd.getLng();
		this.speed = posCmd.getSpeed();
		this.eId = posCmd.getIMEI();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Position[id:" + id + "][time:" + time + "][lat:" + lat + "][lng:" + lng + "][speed:" + speed + "][eId:"
				+ eId + "]";
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

	public void setInRail(boolean inRail) {
		this.inRail = inRail;
	}

	public boolean isInRail() {
		return inRail;
	}

}

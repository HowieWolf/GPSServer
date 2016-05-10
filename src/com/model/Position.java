package com.model;

import com.equip.out.cmd.PositionCommand;

public class Position {
	
	private int id;
	private String dateTime;
	private double lat;
	private double lng;
	private double speed;
	private String eId;
	
	public Position(PositionCommand posCmd) {
		this.dateTime = posCmd.getDateTime();
		this.lat = posCmd.getLat();
		this.lng = posCmd.getLng();
		this.speed = posCmd.getSpeed();
		this.eId = posCmd.getIMEI();
	}

}

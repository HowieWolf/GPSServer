package com.app.service;

import java.util.List;

import com.model.Rail;

public interface SettingService {

	public void addRail(Rail rail);

	public void modifyRail(Rail rail);
	
	public List<Rail> getEquipRail(String eId);

}
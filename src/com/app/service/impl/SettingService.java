package com.app.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.dao.RailDao;
import com.equip.controller.GPSEquipment;
import com.equip.manager.EquipManager;
import com.model.Rail;

@Repository
public class SettingService {

	@Resource
	EquipManager equipManager;
	
	@Resource
	RailDao railDao;
	
	public void addRail(Rail rail){
		railDao.addRail(rail);
		GPSEquipment equip = equipManager.getEquip(rail.geteId());
		if(equip != null){
			equip.addRail(rail);
		}
	}
	
}

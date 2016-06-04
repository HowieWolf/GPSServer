package com.app.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.app.service.SettingService;
import com.dao.RailDao;
import com.equip.controller.GPSEquipment;
import com.equip.manager.EquipManager;
import com.model.Rail;

@Repository("settingSerivce")
public class SettingServiceImpl implements SettingService {

	@Resource
	EquipManager equipManager;
	
	@Resource
	RailDao railDao;
	
	/* (non-Javadoc)
	 * @see com.app.service.impl.SettingService#addRail(com.model.Rail)
	 */
	@Override
	public void addRail(Rail rail){
		railDao.addRail(rail);
		GPSEquipment equip = equipManager.getEquip(rail.geteId());
		if(equip != null){
			equip.addRail(rail);
		}
	}
	
	@Override
	public List<Rail> getEquipRail(String eId){
		return railDao.queryRails(eId);
	}
	
	/* (non-Javadoc)
	 * @see com.app.service.impl.SettingService#modifyRail(com.model.Rail)
	 */
	@Override
	public void modifyRail(Rail rail){
		
	}
	
}

package com.app.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.service.SettingService;
import com.model.Rail;
import com.model.VersionInfo;

@RequestMapping("/setting")
@Controller
public class SettingController {

	@Resource
	SettingService settingService;
	
	/**
	 * 设置围栏
	 */
	@RequestMapping("/addRail")
	@ResponseBody
	public boolean addRail(String eId , double lat , double lng , double radius){
		settingService.addRail(new Rail(eId, lat, lng, radius));
		return true;
	}
	
	/**
	 * 获取某设备的围栏
	 */
	@RequestMapping("/getEquipRail")
	@ResponseBody
	public List<Rail> getEquipRail(String eId){
		return settingService.getEquipRail(eId);
	}
	
	@RequestMapping("/checkUpdate")
	@ResponseBody
	public VersionInfo checkUpdate(){
		return settingService.checkUpdate();
	}
	
}

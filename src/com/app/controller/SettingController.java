package com.app.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.service.impl.SettingService;
import com.model.Rail;

@RequestMapping("/setting")
@Controller
public class SettingController {

	@Resource
	SettingService settingService;
	
	/**
	 * 设置围栏
	 */
	@RequestMapping("/addRail")
	public void addRail(String eId , double lat , double lng , double radius){
		settingService.addRail(new Rail(eId, lat, lng, radius));
	}
	
}

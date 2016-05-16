package com.app.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.service.EquipService;
import com.app.service.impl.EquipServiceImpl;
import com.test.TestEquip;

@RequestMapping("/equip")
@Controller
public class EquipController {

	@Resource
	private EquipService equipService;
	
	@RequestMapping("/alertMedicine")
	@ResponseBody
	public String alertMedicine(String eId){
		eId = TestEquip.IMIE;
		if(equipService.handleAlertMedicine(eId)){
			return "success";
		}
		return "fail";
	}
	
	@RequestMapping("/leaveSecurity")
	@ResponseBody
	public String leaveSecurity(String eId , String phone){
		eId= TestEquip.IMIE;
		if(((EquipServiceImpl)equipService).handleAwaySecurity(eId , phone)){
			return "success";
		}
		return "fail";
	}
	
}

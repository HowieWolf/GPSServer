package com.app.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.service.EquipService;
import com.test.TestEquip;

@RequestMapping("/equip")
@Controller
public class EquipController {

	@Resource
	private EquipService equipService;
	
	@RequestMapping("/alertMedicine")
	public void alertMedicine(String eId){
		eId = TestEquip.IMIE;
		equipService.handleAlertMedicine(eId);
	}
	
	@RequestMapping("/leaveSecurity")
	public void leaveSecurity(String eId){
		eId= TestEquip.IMIE;
		equipService.handleAwaySecurity(eId);
	}
	
}

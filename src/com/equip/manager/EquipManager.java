package com.equip.manager;

import java.util.HashMap;

import com.equip.controller.GPSEquipment;

public class EquipManager extends HashMap<String, GPSEquipment>{
	
	public void addEquip(GPSEquipment equip){
		this.put(equip.geteId(), equip);
		System.out.println(this.size());
	}
	
	public void deleteEquip(String eId){
		this.remove(eId);
		System.out.println(this.size());
	}
	
	public void deleteEquip(GPSEquipment equip){
		this.remove(equip.geteId());
		System.out.println(this.size());
	}
	
}

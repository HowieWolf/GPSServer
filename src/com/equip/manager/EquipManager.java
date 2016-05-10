package com.equip.manager;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.equip.controller.GPSEquipment;

@Repository
public class EquipManager extends HashMap<String, GPSEquipment>{

	public void addEquip(GPSEquipment equip){
		this.put(equip.geteId(), equip);
		System.out.println("addEquip" + this.size());
	}
	
	public void deleteEquip(String eId){
		this.remove(eId);
		System.out.println("deleteEquip" + this.size());
	}
	
	public void deleteEquip(GPSEquipment equip){
		this.remove(equip.geteId());
		System.out.println("deleteEquip" + this.size());
	}
	
}

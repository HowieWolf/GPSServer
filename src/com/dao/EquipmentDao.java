package com.dao;

import com.model.Equipment;

public interface EquipmentDao {

	public void addEquip(Equipment equip);
	
	public Equipment queryEquip(String id);
	
}

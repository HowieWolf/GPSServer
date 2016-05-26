package com.dao;

import java.util.List;

import com.model.Equipment;

public interface EquipmentDao {

	public void addEquip(Equipment equip);
	
	public void updateEquip(Equipment equip);
	
	public void updateEquip(String id);
	
	public Equipment queryEquipById(String id);
	
	public List<Equipment> queryEquipsByUid(int id);
	
}

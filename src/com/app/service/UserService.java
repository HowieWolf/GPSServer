package com.app.service;

import java.util.Map;

import com.model.Equipment;
import com.model.User;

public interface UserService {

	public boolean addEquip(Equipment equip);
	
	public void deleteEquip(String id);
	
	public boolean signin(User user);

	public Map<String, Object> login(User user);

}
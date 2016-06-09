package com.app.service;

import java.util.Map;

import com.model.Equipment;
import com.model.User;

public interface UserService {

	public static final int LOGIN_SUCCESS = 0;
	public static final int LOGIN_ERROR_USERNAME = 1;
	public static final int LOGIN_ERROR_PASSWORD = 2;
	
	public static final int ADD_SUCCESS = 0;
	public static final int ADD_ERROR_IMEI = 1;
	public static final int ADD_ERROR_PHONE = 2;
	public static final int ADD_ERROR_USER = 3;
	
	public int addEquip(Equipment equip , String phone);
	
	public void deleteEquip(int id);
	
	public boolean signin(User user);

	public Map<String, Object> login(User user);

}
package com.app.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.app.service.UserService;
import com.dao.EquipmentDao;
import com.dao.UserDao;
import com.model.Equipment;
import com.model.User;

@Repository("userService")
public class UserServiceImpl implements UserService {

	@Resource
	UserDao userDao;

	@Resource(name = "equipmentDao")
	EquipmentDao equipDao;

	@Override
	public boolean signin(User user) {
		User query = userDao.queryUserByUsername(user.getUsername());
		if (query != null) {
			return false;
		}
		userDao.addUser(user);
		return true;
	}

	@Override
	public Map<String, Object> login(User user) {
		Map<String, Object> result = new HashMap<>();
		User query = userDao.queryUserByUsername(user.getUsername());
		if (query == null) {
			result.put("error", 1);
		} else if (user.getPassword().equals(query.getPassword())) {
			result.put("error", 0);
			result.put("user", query);
			result.put("equips", equipDao.queryEquipsByUid(query.getId()));
		} else {
			result.put("error", 2);
		}
		return result;
	}
	
	@Override
	public boolean addEquip(Equipment equip) {
		Equipment query = equipDao.queryEquipById(equip.getId());
		if(query.getuId() > 0){
			return false;
		}
		equipDao.updateEquip(equip);
		return true;
	}
	
	@Override
	public void deleteEquip(String id) {
		equipDao.updateEquip(id);
	}

}

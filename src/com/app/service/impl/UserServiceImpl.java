package com.app.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.app.service.UserService;
import com.dao.EquipmentDao;
import com.dao.UserDao;
import com.model.Equip;
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
			result.put("error", UserService.LOGIN_ERROR_USERNAME);
		} else if (user.getPassword().equals(query.getPassword())) {
			result.put("error", UserService.LOGIN_SUCCESS);
			result.put("user", query);
			result.put("equips", equipDao.queryEquipsByUid(query.getId()));
		} else {
			result.put("error", UserService.LOGIN_ERROR_PASSWORD);
		}
		return result;
	}

	@Override
	public int addEquip(Equipment equip, String phone) {
		/**
		 * 首先查找设备，判断是否有该设备
		 */
		Equip equipInfo = equipDao.queryEquipByIMEI(equip.geteId());
		if (equipInfo == null) {
			return UserService.ADD_ERROR_IMEI;
		}
		/**
		 * 判断手机号码是否正确
		 
		if (!equipInfo.getPhone().equals(phone)) {
			return UserService.ADD_ERROR_PHONE;
		}*/

		/**
		 * 判断用户是否已经添加该设备
		 */
		Integer id = equipDao.queryEquipByUidAndEid(equip);
		if (id != null) {
			return UserService.ADD_ERROR_USER;
		}
		equipDao.addEquipForUser(equip);
		return UserService.ADD_SUCCESS;
	}

	@Override
	public void deleteEquip(int id) {
		equipDao.deleteEquipForUser(id);
	}

}

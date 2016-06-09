package com.dao;

import java.util.List;

import com.model.Equip;
import com.model.Equipment;

public interface EquipmentDao {

	/**
	 * 向Equip表中添加一条记录，只有IMEI一个字段
	 * @param IMEI
	 */
	public void addEquip(Equip equip);
	
	/**
	 * 向Equipment中添加一条记录
	 * 记录的是某用户添加了某设备
	 * 实现了同一设备被多个用户使用，还有一个用户可以拥有多个设备
	 * @param equip
	 */
	public void addEquipForUser(Equipment equip);
	
	/**
	 * 当用户修改设备信息时
	 * @param equip
	 */
	public void updateEquipForUser(Equipment equip);
	
	/**
	 * 用户删除自己的设备，但并不影响其他人使用该设备
	 * @param id
	 */
	public void deleteEquipForUser(int id);
	
	/**
	 * 用户查找自己的设备列表，准确的说是查询添加记录
	 * @param id
	 * @return
	 */
	public List<Equipment> queryEquipsByUid(int id);
	
	/**
	 * 查询连入服务器的设备，在Equip表中
	 * @param eid
	 * @return
	 */
	public Equip queryEquipByIMEI(String eid);
	
	/**
	 * 根据uid和eId查找添加记录
	 * @param equip
	 * @return
	 */
	public Integer queryEquipByUidAndEid(Equipment equip);
	
	/**
	 * 根据id查找添加记录
	 */
	public Equipment queryEquipById(int id);
}

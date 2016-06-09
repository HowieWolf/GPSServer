package com.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.dao.EquipmentDao;
import com.model.Equip;
import com.model.Equipment;

@Repository("equipmentDao")
public class MySqlEquipmentDao extends SqlSessionDaoSupport implements EquipmentDao {

	@Override
	public void addEquipForUser(Equipment equip) {
		getSqlSession().insert("addEquipForUser" , equip);
	}
	
	@Override
	public void updateEquipForUser(Equipment equip) {
		getSqlSession().update("updateEquip", equip);
	}
	
	@Override
	public List<Equipment> queryEquipsByUid(int uId) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("selectEquipByUid", uId);
	}


	@Override
	public void addEquip(Equip equip) {
		// TODO Auto-generated method stub
		getSqlSession().insert("addEquip", equip);
	}

	@Override
	public void deleteEquipForUser(int id) {
		getSqlSession().delete("deleteEquipForUser" , id);
	}

	@Override
	public Equip queryEquipByIMEI(String IMEI) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("selectEquipByIMEI" , IMEI);
	}

	@Override
	public Integer queryEquipByUidAndEid(Equipment equip) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("selectEquipByUidAndEid", equip);
	}
	
	@Override
	public Equipment queryEquipById(int id) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("selectEquipById" , id);
	}
	
	@Resource
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}


}

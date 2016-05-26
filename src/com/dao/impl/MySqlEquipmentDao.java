package com.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.dao.EquipmentDao;
import com.model.Equipment;

@Repository("equipmentDao")
public class MySqlEquipmentDao extends SqlSessionDaoSupport implements EquipmentDao {

	@Override
	public void addEquip(Equipment equip) {
		getSqlSession().insert("addEquip" , equip);
	}
	
	@Override
	public void updateEquip(Equipment equip) {
		getSqlSession().update("updateEquip", equip);
	}
	
	@Override
	public void updateEquip(String id) {
		getSqlSession().update("updateEquipOnlyUid", id);
	}

	@Override
	public Equipment queryEquipById(String id) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("selectEquipById" , id);
	}
	
	@Override
	public List<Equipment> queryEquipsByUid(int uId) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("selectEquipByUid", uId);
	}

	@Resource
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}

}

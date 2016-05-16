package com.dao.impl;

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
	public Equipment queryEquip(String id) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("selectEquip" , id);
	}

	@Resource
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}

}

package com.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.dao.RailDao;
import com.model.Rail;

@Repository("railDao")
public class MySqlRailDao extends SqlSessionDaoSupport implements RailDao{

	@Override
	public void addRail(Rail rail) {
		// TODO Auto-generated method stub
		getSqlSession().insert("addRail", rail);
	}

	@Override
	public Rail queryRail(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Rail> queryRails(String eId) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("selectRails", eId);
	}
	
	@Resource
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}

}

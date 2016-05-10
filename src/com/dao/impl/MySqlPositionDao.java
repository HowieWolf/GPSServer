package com.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.dao.PositionDao;
import com.model.Position;

@Repository("positionDao")
public class MySqlPositionDao extends SqlSessionDaoSupport implements PositionDao{

	
	
	@Override
	public void addPosition(Position pos) {
		// TODO Auto-generated method stub
		getSqlSession().insert("addPosition" , pos);
	}

	@Override
	public List<Position> queryPosition() {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("PositionMapper.selectPosition");
	}

	@Resource
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
}

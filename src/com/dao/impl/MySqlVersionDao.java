package com.dao.impl;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.dao.VersionDao;
import com.model.VersionInfo;

@Repository("versionDao")
public class MySqlVersionDao extends SqlSessionDaoSupport implements VersionDao{

	@Override
	public VersionInfo queryVersion() {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("selectVersion");
	}

	@Override
	public void addVersion(VersionInfo info) {
		// TODO Auto-generated method stub
		getSqlSession().insert("addVersion", info);
	}
	
	@Resource
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	

}

package com.dao.impl;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.dao.UserDao;
import com.model.User;

@Repository("userDao")
public class MySqlUserDao extends SqlSessionDaoSupport implements UserDao {

	@Override
	public void addUser(User user) {
		getSqlSession().insert("addUser", user);
	}
	
	@Override
	public User queryUserById(int id) {
		return getSqlSession().selectOne("selectUserById", id);
	}

	@Override
	public User queryUserByUsername(String username) {
		return getSqlSession().selectOne("selectUserByUsername", username);
	}

	@Resource
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

}

package com.equip.controller;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.RailDao;
import com.model.Rail;
import com.model.User;

@Controller
public class TestMyBatis {

	@Resource(name = "railDao")
	RailDao dao;
	
	
	@RequestMapping("/rail")
	@ResponseBody
	public List<Rail> query(String id){
		return dao.queryRails(id);
	}
	
	public static void main(String[] args) throws IOException {
		
		Reader reader = Resources.getResourceAsReader("config/orm/mybatis/mybatisConfig.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		
		SqlSession session = sessionFactory.openSession();
		List<User> users = new ArrayList(session.selectList("selectPosition"));
		System.out.println(users.size());
		for(int i = 0; i < users.size() ; i++){
			System.out.println(users.get(i));
		}
		
		
	}
	
}

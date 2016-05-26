package com.test;

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

	
	SqlSession session;
	
	public static void main(String[] args) throws IOException {
		
		TestMyBatis test = new TestMyBatis();
		test.connecteDatabase();
		
		
	}

	public void connecteDatabase() throws IOException {
		Reader reader = Resources.getResourceAsReader("config/orm/mybatis/mybatisConfig.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		session = sessionFactory.openSession();
	}
	
}

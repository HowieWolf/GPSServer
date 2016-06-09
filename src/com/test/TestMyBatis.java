package com.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;

import com.model.Equipment;

@Controller
public class TestMyBatis {

	
	SqlSession session;
	
	public static void main(String[] args) throws IOException {
		
		TestMyBatis test = new TestMyBatis();
		test.connecteDatabase();
		//test.testAddEquipForUser(test);
		Equipment e = new Equipment();
		e.seteId("36");
		e.setuId(2);
		e.setName("dasf");
		test.testSelectEquipByUidAndEid(e);
	}
	
	public void testSelectEquipByUidAndEid(Equipment e){
		System.out.println(session.selectOne("selectEquipByUidAndEid" , e));
	}

	public void testAddEquipForUser(TestMyBatis test) {
		Equipment e = new Equipment();
		e.seteId("865456");
		e.setuId(2);
		e.setName("dasf");
		test.session.insert("addEquipForUser" , e);
	}

	public void connecteDatabase() throws IOException {
		Reader reader = Resources.getResourceAsReader("config/orm/mybatis/testMybatisConfig.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		session = sessionFactory.openSession();
	}
	
}

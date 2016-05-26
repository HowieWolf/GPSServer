package com.dao;

import com.model.User;

public interface UserDao {

	public void addUser(User user);
	
	public User queryUserById(int id);

	public User queryUserByUsername(String username);
}
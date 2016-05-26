package com.app.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.service.UserService;
import com.model.Equipment;
import com.model.User;

@RequestMapping("/user")
@Controller
public class UserController {

	@Resource
	UserService userService;
	
	@RequestMapping("/addEquip")
	@ResponseBody
	public boolean addEquip(Equipment e){
		return userService.addEquip(e);
	}
	
	@RequestMapping("/deleteEquip")
	public void deleteEquip(String id){
		userService.deleteEquip(id);
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public Map<String, Object> login(User user) {
		return userService.login(user);
	}

	@RequestMapping("/signin")
	@ResponseBody
	public boolean signin(User user) {
		return userService.signin(user);
	}

}

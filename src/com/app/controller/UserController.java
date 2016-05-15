package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.User;

@RequestMapping("/user")
@Controller
public class UserController {

	@RequestMapping("/login")
	@ResponseBody
	public User login() {
		User user = null;

		return user;
	}

	@RequestMapping("/signin")
	@ResponseBody
	public User signin() {
		User user = null;

		return user;
	}

}

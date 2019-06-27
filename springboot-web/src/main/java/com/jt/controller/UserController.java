package com.jt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.pojo.User;
import com.jt.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/findAll")

	public String findAll(Model model){
		
		List<User> userList = userService.findAll();
		//model底层将数据保存到了request域中
		model.addAttribute("userList",userList);
		return "userList";
	}
	
}

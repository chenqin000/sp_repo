package com.jt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.mapper.UserMapper;
import com.jt.pojo.User;
@Service
public class UserServiceImp implements UserService {
	//接口实例化 1.创建实现类 2.创建代理对象  a.JDK原生代理  b.CGLIB代理
	//原则：如果代理对象有接口则使用jdk代理
	//如果代理者没有实现接口 则使用cglib代理
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> findAll() {
		return userMapper.findAll();
	
		
	}

	@Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.insertUser(user);
	}
}

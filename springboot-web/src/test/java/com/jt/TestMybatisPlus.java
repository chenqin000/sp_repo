package com.jt;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.jt.mapper.UserMapper;
import com.jt.pojo.User;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestMybatisPlus {
	@Autowired
	private UserMapper usermapper;
	@Test
	public void insert() {
		User user = new User();
		user.setAge(20);
		user.setName("李云龙");
		user.setSex("男");
		usermapper.insert(user);
	}
	//2.查询
	@Test
	public void testFind() {
		//1.使用对象封装封装
		//User user = new User();
		//user.setAge(18);
		//2.直接使用字段赋值
		QueryWrapper<User> queryWrapper=new QueryWrapper<>();
		queryWrapper.eq("age", 18);
		//queryWrapper.ge("age", 18);大于18
		List<User> list = usermapper.selectList(queryWrapper);
		System.err.println(list);
	}
	
	/**3.数据更新 将年龄为18岁的用户改为19岁
	 * entity:需要修改的数据的值
	 * updateWrapper:条件构造器 充当where条件
	*/
	@Test
	public void testUpdate() {
		User user = new User();
		user.setAge(19);
		UpdateWrapper<User> updateWrapper =
				new UpdateWrapper<>();
		updateWrapper.eq("age", 18);
		usermapper.update(user, updateWrapper);
	}
	@Test
	public void deleteUser() {
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.isNull("name");
		usermapper.delete(queryWrapper);
	}
	
}

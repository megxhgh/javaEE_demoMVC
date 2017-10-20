package com.gxh.service.impl;

import java.util.List;

import com.gxh.dao.UserDao;
import com.gxh.dao.impl.UserDaoImpl;
import com.gxh.entity.User;
import com.gxh.service.UserService;

public class UserServiceImpl implements UserService {
	
	UserDao userDao = new UserDaoImpl();
	public void register(User user) throws Exception {
		// TODO Auto-generated method stub
		userDao.addUser(user);
	}
	public User login(User user) throws Exception {
			return userDao.findUser(user);
		
	}
	public boolean registerUsernameValidate(String username) throws Exception{
			return userDao.findUserByUsername(username);
	}
	public List<User> findAllUser() throws Exception {
		// TODO Auto-generated method stub
		return userDao.findAllUser();	
	}		
		

}

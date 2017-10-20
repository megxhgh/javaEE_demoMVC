package com.gxh.dao;

import java.util.List;

import com.gxh.entity.User;

public interface UserDao {
	public void addUser(User user)throws Exception;
	public User findUser(User user)throws Exception;
	public boolean findUserByUsername(String username) throws Exception;
	public List<User> findAllUser()throws Exception;
		
}

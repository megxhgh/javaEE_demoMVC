package com.gxh.service;

import java.util.List;

import com.gxh.entity.User;

public interface UserService {
	public void register(User user)throws Exception;
	public User login(User user)throws Exception;
	public boolean registerUsernameValidate(String username)throws Exception;
	public List<User> findAllUser()throws Exception;
}

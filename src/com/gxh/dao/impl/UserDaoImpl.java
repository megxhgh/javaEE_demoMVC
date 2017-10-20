package com.gxh.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.gxh.dao.UserDao;
import com.gxh.entity.User;
import com.gxh.utils.DBUtils;

public class UserDaoImpl implements UserDao {
	//��ӵ����û�
	public void addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		try {	
			conn = DBUtils.getConnection();
			String sql = "insert into users(username,password,email,birth) values(?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			//��birthʹ��date����
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String date = sdf.format(user.getBirth());
			ps.setString(4, date);
			 
//			ps.setString(4, user.getBirth());
			int i = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("����쳣��");
		} finally{
			DBUtils.closeAll(ps, conn);
		}
	
	}
	//���ҵ����û�
	public User findUser(User user){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User u = null;
		
		try {
			conn = DBUtils.getConnection();
			String sql = "select * from users where username=? and password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			rs = ps.executeQuery();
			if(rs.next()){
				u = new User();
				u.setId(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setBirth(rs.getDate(5));		
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.closeAll(rs, ps, conn);
		}
		
		return u;
	}
	//ͨ���û��������û�
	public boolean findUserByUsername(String username) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		conn = DBUtils.getConnection();
		String sql = "select * from users where username=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		rs = ps.executeQuery();
		if(rs.next()){
			return true;
		}
		return false;
	}
	//���������û�
	public List<User> findAllUser() throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		List<User> userList = new ArrayList<User>();
				
		conn = DBUtils.getConnection();
		String sql = "select * from users";
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()){
			user = new User();
			user.setId(rs.getInt(1));
			user.setUsername(rs.getString(2));
			user.setEmail(rs.getString(4));
			user.setBirth(rs.getDate(5));
			userList.add(user);
		}
		return userList;
	}

}

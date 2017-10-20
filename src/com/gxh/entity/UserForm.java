package com.gxh.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class UserForm {
	private int id;
	private String username;
	private String password;
	private String repassword;
	private String email;
	private String birth;
	
	Map<String, String> msg = new HashMap<String, String>();
	
	public boolean validate(){
		//验证用户名
		if("".equals(username)){
			msg.put("username", "用户名不能为空！");
		}else if(!username.matches("\\w{6,16}")){	//用户名必须为6-16字母或数字组成
			msg.put("username", "用户名必须为6-16位字母或数字组成！");
		}
		//验证密码
		if("".equals(password)){
			msg.put("password", "密码不能为空！");
		}else if(!password.matches("\\d{6,16}")){	//密码必须为6-16字母组成
			msg.put("password", "密码必须为6-16位数字组成！");
		}
		//确认密码
		if(!password.equals(repassword)){
			msg.put("repassword", "两次密码不相同！");
		}
		//验证邮箱
		if("".equals(email)){
			msg.put("email", "邮箱不能为空！");
		}else if(!email.matches("^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$")){	//用户名必须为6-16字母组成
			msg.put("email", "邮箱格式错误！");
		}
		//验证生日
		if("".equals(birth)){
			msg.put("birth", "出生日期不能为空！");
		}else{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				sdf.parse(birth);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				msg.put("birth", "出生日期格式错误！");
				e.printStackTrace();
			}
		}
		return msg.isEmpty();
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public Map<String, String> getMsg() {
		return msg;
	}
	public void setMsg(Map<String, String> msg) {
		this.msg = msg;
	}
	
	
}

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
		//��֤�û���
		if("".equals(username)){
			msg.put("username", "�û�������Ϊ�գ�");
		}else if(!username.matches("\\w{6,16}")){	//�û�������Ϊ6-16��ĸ���������
			msg.put("username", "�û�������Ϊ6-16λ��ĸ��������ɣ�");
		}
		//��֤����
		if("".equals(password)){
			msg.put("password", "���벻��Ϊ�գ�");
		}else if(!password.matches("\\d{6,16}")){	//�������Ϊ6-16��ĸ���
			msg.put("password", "�������Ϊ6-16λ������ɣ�");
		}
		//ȷ������
		if(!password.equals(repassword)){
			msg.put("repassword", "�������벻��ͬ��");
		}
		//��֤����
		if("".equals(email)){
			msg.put("email", "���䲻��Ϊ�գ�");
		}else if(!email.matches("^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$")){	//�û�������Ϊ6-16��ĸ���
			msg.put("email", "�����ʽ����");
		}
		//��֤����
		if("".equals(birth)){
			msg.put("birth", "�������ڲ���Ϊ�գ�");
		}else{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				sdf.parse(birth);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				msg.put("birth", "�������ڸ�ʽ����");
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

package com.gxh.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gxh.entity.User;
import com.gxh.entity.UserForm;
import com.gxh.service.UserService;
import com.gxh.service.impl.UserServiceImpl;
import com.sun.org.apache.commons.beanutils.BeanUtils;
import com.sun.org.apache.commons.beanutils.ConvertUtils;


import com.sun.org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//接收表单数据
		UserForm uf = new UserForm();
		try {
			BeanUtils.populate(uf, request.getParameterMap());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		//1.验证表单数据的合法性
		if(!uf.validate()){	//验证出错
			request.setAttribute("uf", uf);
			request.getRequestDispatcher("/register.jsp").forward(request, response);
//			request.getSession().setAttribute("uf", uf);
//			response.sendRedirect(request.getContextPath() + "/register.jsp");
			return;
		}
		
		//2.验证注册用户名是否存在
		String username = request.getParameter("username");
		UserService usFindUsername = new UserServiceImpl();
		try {
			if(usFindUsername.registerUsernameValidate(username)){
				request.setAttribute("uf", uf);
				request.setAttribute("usernameExist", "该用户名已注册！");
				request.getRequestDispatcher("/register.jsp").forward(request, response);
				return;
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//3.
		User user = new User();
		try {
			/* 如果birth使用date类型,则使用该语句		*/
			//ConvertUtils.register(new DateLocaleConverter(),Date.class);有问题！！！！
			ConvertUtils.register(new DateLocaleConverter(Locale.CHINESE, "yyyy-MM-dd"),Date.class);
			BeanUtils.populate(user, request.getParameterMap());
		//处理业务逻辑	
			UserService usRegister = new UserServiceImpl();			
			usRegister.register(user);
			response.getWriter().write("注册成功，3秒后跳转到登录页面！");
			response.setHeader("refresh", "3,url="+ request.getContextPath() +"/login.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.getWriter().write("注册失败，3秒后跳转到注册页面！");
			response.setHeader("refresh", "3,url="+ request.getContextPath() +"/register.jsp");
			e.printStackTrace();
		}
	
		//分发转向
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

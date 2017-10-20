package com.gxh.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gxh.entity.User;
import com.gxh.service.UserService;
import com.gxh.service.impl.UserServiceImpl;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String code = request.getParameter("code");
		String scode = (String) request.getSession().getAttribute("scode");
		
		User user = new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
			UserService us = new UserServiceImpl();
			User u = us.login(user);
			if(u != null){
				request.getSession().setAttribute("user", u);
				//request.setAttribute("user", u);
				if(scode.equalsIgnoreCase(code)){				
					response.sendRedirect(request.getContextPath() + "/success.jsp");
					//request.getRequestDispatcher("/success.jsp").forward(request, response);
				}else{
					request.setAttribute("codeError", "验证码错误!");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}
				
			}else{
				request.setAttribute("loginError", "用户名或密码错误!");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
			//response.getWriter().write("登录成功！");
			//request.getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

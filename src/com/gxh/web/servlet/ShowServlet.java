package com.gxh.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gxh.entity.User;
import com.gxh.service.UserService;
import com.gxh.service.impl.UserServiceImpl;

public class ShowServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		List<User> userList = new ArrayList<User>();
		UserService us = new UserServiceImpl();
		try {
			userList = us.findAllUser();
			request.setAttribute("userList", userList);
			request.getRequestDispatcher("/showUser.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.getWriter().write("查询失败！3秒后返回个人中心页面！");
			response.setHeader("refresh", "3,url="+ request.getContextPath()+"/success.jsp");
			e.printStackTrace();
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

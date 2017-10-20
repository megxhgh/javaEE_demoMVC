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
		//���ձ�����
		UserForm uf = new UserForm();
		try {
			BeanUtils.populate(uf, request.getParameterMap());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		//1.��֤�����ݵĺϷ���
		if(!uf.validate()){	//��֤����
			request.setAttribute("uf", uf);
			request.getRequestDispatcher("/register.jsp").forward(request, response);
//			request.getSession().setAttribute("uf", uf);
//			response.sendRedirect(request.getContextPath() + "/register.jsp");
			return;
		}
		
		//2.��֤ע���û����Ƿ����
		String username = request.getParameter("username");
		UserService usFindUsername = new UserServiceImpl();
		try {
			if(usFindUsername.registerUsernameValidate(username)){
				request.setAttribute("uf", uf);
				request.setAttribute("usernameExist", "���û�����ע�ᣡ");
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
			/* ���birthʹ��date����,��ʹ�ø����		*/
			//ConvertUtils.register(new DateLocaleConverter(),Date.class);�����⣡������
			ConvertUtils.register(new DateLocaleConverter(Locale.CHINESE, "yyyy-MM-dd"),Date.class);
			BeanUtils.populate(user, request.getParameterMap());
		//����ҵ���߼�	
			UserService usRegister = new UserServiceImpl();			
			usRegister.register(user);
			response.getWriter().write("ע��ɹ���3�����ת����¼ҳ�棡");
			response.setHeader("refresh", "3,url="+ request.getContextPath() +"/login.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.getWriter().write("ע��ʧ�ܣ�3�����ת��ע��ҳ�棡");
			response.setHeader("refresh", "3,url="+ request.getContextPath() +"/register.jsp");
			e.printStackTrace();
		}
	
		//�ַ�ת��
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>登录成功</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<% 		
  		if(session.getAttribute("user") == null){
  			response.sendRedirect(request.getContextPath() + "/login.jsp");
  		}	
  	 %>
  
 	欢迎您：${user.username }&nbsp;
    <a href="${pageContext.request.contextPath }/servlet/logoutServlet">注销</a><br/>
    <a href="${pageContext.request.contextPath }/servlet/showServlet" target="_blank">查看所有用户</a>
 
  </body>
</html>

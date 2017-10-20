<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>用户列表</title>
    
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
  	 <h1 align="center">用户列表</h1>
  	 <hr/><br/>
  	 <table border="1">
  	 	<tr>
  	 		<th>用户ID</th>
  	 		<th>用户名</th>
  	 		<th>邮箱</th>
  	 		<th>出生日期</th>
  	 	</tr>
  	 	<c:forEach items="${userList }" var="user" varStatus="vs">
  	 		<tr ${vs.count%2==0 ? "style='background-color:red'" : "style='background-color:green'"}>
  	 			<td>${user.id }</td>
  	 			<td>${user.username }</td>
  	 			<td>${user.email }</td>
  	 			<td>${user.birth }</td>
  	 		</tr>
  	 	</c:forEach>
  	 </table>
  	 
  </body>
</html>

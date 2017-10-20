<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <title>用户登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function changeCode(){
			var img = document.getElementsByTagName("img")[0];
			img.src = "/javaEE2/servlet/codeServlet?time="+new Date().getTime();
		}
		function check(){
			if(loginForm.username.value==""){
				alert("用户名不能为空！");
				loginForm.username.focus();
				return false;
			}
			if(loginForm.password.value==""){
				alert("密码不能为空！");
				loginForm.password.focus();
				return false;
			}
			return true;
		}
	</script>
	<style type="text/css">
		.codeError,h4{
			color:red;
		}
	</style>
  </head>
  
  <body>
  
	  <div align="center">
	  	<h4 >${loginError }</h4>
		<form name="loginForm" action="${pageContext.request.contextPath }/servlet/loginServlet" method="post">
			<table border="1" >
				<tr height="30">
					<th colspan="2">用户登录</th>
				</tr>
				<tr height="30">
					<td>用户名：</td>
					<td><input type="text" name="username" value="${user.username }"/></td>
				</tr>
				<tr height="30">
					<td>密码：</td>
					<td><input type="password" name="password" value="${user.password }"/></td>
				</tr>
				<tr height="30">
					<td>验证码：</td>
					<td>
						<input type="text" name="code"/>
						<%-- <div class="codeError">${codeError }</div> --%>
						<strong class="codeError">${codeError }</strong>
					</td>
				</tr>
				<tr height="30">
					<td colspan="2" align="center">
						<img alt="" width="100" height="25" src="${pageContext.request.contextPath }/servlet/codeServlet" onclick="changeCode()"/>&nbsp;&nbsp;
						<a href="javascript:changeCode()">看不清，换一张</a>
					</td>
				</tr>
				<tr height="30">
					<td colspan="2" align="center">
						<input type="submit" value="登录" onclick="check()"/>
						<input type="reset" value="重置"/>
					</td>
				</tr>
			</table>
		</form>
	</div>
  </body>
</html>

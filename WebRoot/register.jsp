<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>用户注册</title>
		<!-- <script type="text/javascript" >
			function reset(){
				registerForm.username.value = "";
				registerForm.password.value = "";
				registerForm.repassword.value = "";
				registerForm.email.value = "";
				registerForm.birth.value = "";
			}
		</script> -->
	</head>
	<body >
		<%-- 
		<form name = "registerForm" action="${pageContext.request.contextPath }/servlet/registerServlet" method="post">
			用户名：<input type="text" name="username" value="${uf.username }"/>&nbsp;${uf.msg.username }${usernameExist }<br/>
			密码：<input type="password" name="password"/>&nbsp;${uf.msg.password }<br/>
			确认密码：<input type="password" name="repassword"/>&nbsp;${uf.msg.repassword }<br/>
			邮箱：<input type="text" name="email" value="${uf.email }"/>&nbsp;${uf.msg.email }<br/>
			出生日期：<input type="text" name="birth" value="${uf.birth }"/>&nbsp;${uf.msg.birth }<br/>
			<input type="submit" value="注册"/>&nbsp;&nbsp;
			<!-- <input type="reset" value="重置" /><br/> -->
		</form>
		 --%>
	<%-- table表格形式 --%>
		<form action="${pageContext.request.contextPath }/servlet/registerServlet" method="post">
			<table border="1" align="center">
				<tr>
					<th colspan="2">用户注册</th>
				</tr>
				<tr>
					<td>用户名:</td>
					<td><input type="text" name="username" value="${uf.username }"/>&nbsp;${uf.msg.username }${usernameExist }</td>
				</tr>
				<tr>
					<td>密码:</td>
					<td><input type="password" name="password"/>&nbsp;${uf.msg.password }</td>
				</tr>
				<tr>
					<td>确认密码:</td>
					<td><input type="password" name="repassword"/>&nbsp;${uf.msg.repassword }</td>
				</tr>
				<tr>
					<td>邮箱:</td>
					<td><input type="text" name="email" value="${uf.email }"/>&nbsp;${uf.msg.email }</td>
				</tr>
				<tr>
					<td>出生日期:</td>
					<td><input type="text" name="birth" value="${uf.birth }"/>&nbsp;${uf.msg.birth }</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="注册"/>&nbsp;&nbsp;
						<input type="reset" value="重置"/>	
					</td>
				</tr>
			</table>
		</form>
	
	
	</body>
</html>
<%@page import="com.domain.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录成功</title>
<link rel="stylesheet" href="./css/login.css">
</head>
<body>
	<%
	//确保有用户进入
		if (session.getAttribute("user") != null){
			User user = (User)session.getAttribute("user");
			System.out.println(user.getPath());
			int idx = user.getPath().lastIndexOf("\\");
			//获得唯一文件名
			String filename = user.getPath().substring(idx + 1);
	%>
	<div class="login">
		<div class="header">
			<h1>登录成功</h1>
		</div>
		<div class="content">
			<table align="center">
				<tr>
					<td align="center"><img src= "/JavaWebHomework1/Upload/<%=filename %>" /></td>
				</tr>
				<tr>
					<td align="center">欢迎 ${user.getUsername()} ,登录成功！</td>
				</tr>
			</table>

		</div>
	</div>	
	<%} else {%>
	<div class="login">
		<div class="header">
			<h2>您还没有登录，请先去<a href="/JavaWebHomework1/login.jsp">登录</a>！</h2>

		</div>
	</div>	
	<%} %>
</body>
</html>
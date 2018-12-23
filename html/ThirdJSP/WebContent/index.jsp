<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP Test3</title>
</head>
<body>
	<% 
		List<String> text = new ArrayList<String>();
		text.add("JSP基础入门");
		text.add("Servlet视频讲解");
		text.add("EL表达式初识");
		text.add("JSTL标签库初识");
		for (int i = 1; i <= text.size(); i++){
	%>
	<p>第<%= i %>条：&nbsp <%= text.get(i-1) %> </P>
	<% } %>
</body>
</html>
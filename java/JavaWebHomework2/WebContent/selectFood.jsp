<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>菜品查询选项页面</title>
<style type="text/css">

</style>
</head>
<body>
	<center>
		<p><a href="/JavaWebHomework2/showFoodList.jsp">查询所有菜品信息</a></p>
		<p><a href="/JavaWebHomework2/selectFoodByName.jsp">菜名查询</a></p>
	</center>
</body>
</html>
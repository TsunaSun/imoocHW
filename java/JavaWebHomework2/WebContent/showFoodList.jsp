<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.dao.* , com.domain.*" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>菜品信息展示</title>
<style type="text/css">

</style>
</head>
<body>
	<% int cnt = new FoodDaoImpl().getAllFood().size();%>
	<center>
		<h1>菜品查询</h1>
		<table border="1px" cellspacing="0px" cellpadding="0px" width="800px">
			<thead>
				<tr>
					<th>菜品ID</th>
					<th>菜名</th>
					<th>口味</th>
					<th>菜品图片</th>
					<th>价格</th>
					<th>菜品描述</th>
				</tr>
			</thead>
			<tbody>
				<%
				Food food = (Food)request.getAttribute("food");
				if (food == null){
				for (Food f : new FoodDaoImpl().getAllFood()){ 
					int idx = f.getPath().lastIndexOf("\\");
					//获得唯一文件名
					String filename = f.getPath().substring(idx + 1);
				%>
				<tr>
					<td><%=f.getId() %></td>
					<td><%=f.getName() %></td>
					<td><%=f.getTaste() %></td>
					<td><img alt="" src="/JavaWebHomework2/Upload/<%=filename %>"></td>
					<td><%=f.getPrice() %></td>
					<td><%=f.getDescription() %></td>
				</tr>/
				<%} } else{
					int idx = food.getPath().lastIndexOf("\\");
					//获得唯一文件名
					String filename = food.getPath().substring(idx + 1);
					%>
					<tr>
					<td><%=food.getId() %></td>
					<td><%=food.getName() %></td>
					<td><%=food.getTaste() %></td>
					<td><img alt="" src="/JavaWebHomework2/Upload/<%=filename %>"></td>
					<td><%=food.getPrice() %></td>
					<td><%=food.getDescription() %></td>
				</tr>/
				<%} %>
				
			</tbody>
		</table>
	</center>
</body>
</html>
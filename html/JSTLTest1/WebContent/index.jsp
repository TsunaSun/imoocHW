<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% request.setAttribute("num", 15); %>
	<c:if test="${requestScope.num > 0 && requestScope.num <= 10}">
		<h1>1-10之间的整数</h1>
	</c:if>
	<c:if test="${requestScope.num > 10 && requestScope.num <= 20}">
		<h1>10-20之间的整数</h1>
	</c:if>
</body>
</html>
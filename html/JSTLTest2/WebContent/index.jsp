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
	<% request.setAttribute("day", "Monday"); %>
	<c:choose>
		<c:when test="${day=='Monday' }">
			<h1>周一</h1>
		</c:when>
		<c:when test="${day.equals('Tuesday') }">
			<h1>周二</h1>
		</c:when>
		<c:when test="${day.equals('Wednesday') }">
			<h1>周三</h1>
		</c:when>
		<c:when test="${day.equals('Thuesday') }">
			<h1>周四</h1>
		</c:when>
		<c:when test="${day.equals('Friday') }">
			<h1>周五</h1>
		</c:when>
		<c:when test="${day.equals('Saturday') }">
			<h1>周六</h1>
		</c:when>
		<c:when test="${day.equals('Sunday') }">
			<h1>周日</h1>
		</c:when>
		<c:otherwise>
			<h1>内容不对哦</h1>
		</c:otherwise>
	</c:choose>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Set,java.util.HashSet" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%  Set<String> set = new HashSet<String>();
		set.add("January");
		set.add("February");
		set.add("March");
		set.add("April");
		set.add("May");
		request.setAttribute("set", set);
	%>
	<c:forEach var="m" items="${set}" varStatus="idx">
		<h1>${idx.index + 1}.${m}</h1>
	</c:forEach>
</body>
</html>
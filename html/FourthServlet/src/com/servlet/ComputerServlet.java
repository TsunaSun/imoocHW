package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ComputerServlet extends HttpServlet{
	protected void service(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("utf-8");
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		int sum = num1 + num2;
		PrintWriter out = response.getWriter();
		out.print("<p>加法计算器</p>" + "<p>运算结果为：" + sum + "</p>");

	}

}

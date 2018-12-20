package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThirdServlet extends HttpServlet{
	protected void service(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String num = request.getParameter("n");
		int n = Integer.parseInt(num);
		int sum = 0;
		for (int i = 0; i <=n; i++) {
			sum += i;
		}
		PrintWriter out = response.getWriter();
		out.print("<p style='color : red'>" + sum + "</p>");
	} 
}

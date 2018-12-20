package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接受请求发来的参数
		String name = request.getParameter("name");
		String html = "<h1 style='color : red'>hi " + name + " !</h1> <hr>";
		System.out.println("返回给浏览器的数据为：" + html);
		PrintWriter out = response.getWriter();
		out.print(html);
		
	}

}

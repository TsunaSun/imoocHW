package com.process;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

/**
 * Servlet implementation class Process
 */
@WebServlet("/Process")
public class Process extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Process() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("apple", "苹果");
		map.put("banana", "香蕉");
		map.put("pencil", "铅笔");
		String letter = request.getParameter("letter");
		HttpSession session = request.getSession();
		boolean flag = false;
		if (map.containsKey(letter)) {
			request.setAttribute("result", map.get(letter));
			request.getRequestDispatcher("/success.jsp").forward(request, response);
		} else {
			session.setAttribute("result", "没有找到相应的单词");
			request.getRequestDispatcher("/fail.jsp").forward(request, response);
		}
	}

}

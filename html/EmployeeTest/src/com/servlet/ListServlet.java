package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.Employee;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		if (context.getAttribute("employee") == null) {
			List<Employee> list = new ArrayList<Employee>();
			list.add(new Employee(001,"张三","业务部","部长",5000) );
			list.add(new Employee(002,"李四","业务部","副部长",4000) );
			list.add(new Employee(003,"张五","技术部","部长",8000) );
			list.add(new Employee(004,"王六","管理部","部长",7000) );
			context.setAttribute("employee", list);
		}
		request.getRequestDispatcher("/employee.jsp").forward(request, response);
	}

}

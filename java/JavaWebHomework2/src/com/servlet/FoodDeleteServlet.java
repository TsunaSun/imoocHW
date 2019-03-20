package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.FoodDaoImpl;
import com.domain.Food;

/**
 * Servlet implementation class FoodDeleteServlet
 */
@WebServlet("/FoodDeleteServlet")
public class FoodDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		Food food = new Food();
		FoodDaoImpl foodDaoImpl = new FoodDaoImpl();
		food = foodDaoImpl.getFoodByName(id);
		if (food != null) {
			foodDaoImpl.deleteFoodById(id);
			request.setAttribute("msg", "删除成功");
			request.getRequestDispatcher("/deleteById.jsp").forward(request, response);
			return;
		}
		String msg = "id不存在";
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("/deleteById.jsp").forward(request, response);
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

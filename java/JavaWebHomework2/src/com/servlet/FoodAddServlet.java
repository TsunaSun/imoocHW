package com.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;



import com.dao.FoodDaoImpl;
import com.domain.Food;

/**
 * Servlet implementation class FoodAddServlet
 */
@WebServlet("/FoodAddServlet")
public class FoodAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FoodAddServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// 创建磁盘工厂
			DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
			// 创建核心解析项
			ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
			// 定义map存放临时注册数据
			Map<String, String> map = new HashMap<String, String>();
			// 解析request请求
			List<FileItem> list = (List<FileItem>) servletFileUpload.parseRequest(request);
			// 定义文件上传路径
			String url = null;
			for (FileItem fileItem : list) {
				// 判断是否为文件项
				// 1.表单项
				if (fileItem.isFormField()) {
					String name = fileItem.getFieldName();
					String value = fileItem.getString("utf-8");
					System.out.println(name + value);
					map.put(name, value);
				}
				// 2.文件项(图片
				else {
					String name = fileItem.getName();
					if (name != null && name != "") {
						// 生成唯一文件名
						String UUIDname = com.utils.UploadUUID.getUUIDFileName(name);
						// 创建输入流
						InputStream inputStream = fileItem.getInputStream();
						// 创建路径
						String path = this.getServletContext().getRealPath("/Upload");
						System.out.println(path);
						// 创建完整路径
						url = path + "\\" + UUIDname;
						// 创建输出流
						OutputStream outputStream = new FileOutputStream(url);
						int n = 0;
						byte[] b = new byte[1024];
						while ((n = inputStream.read(b)) != -1) {
							outputStream.write(b, 0, n);
						}
						outputStream.close();
						inputStream.close();
					}
				}
			}
			// 创建数据处理对象
			FoodDaoImpl foodDaoImpl = new FoodDaoImpl();
			// 创建临时food存放对象
			Food food = new Food();
			System.out.println("1");
			// 判断菜名、id是否出现过
			for (Food f : foodDaoImpl.getAllFood()) {
				System.out.println("test");
				if (map.get("id").equals(f.getId())) {
					request.setAttribute("msg", "菜品id已存在");
					request.getRequestDispatcher("/addFood.jsp").forward(request, response);
					return;
				}
				if (map.get("foodName").equals(f.getName())) {
					request.setAttribute("msg", "菜品名已存在");
					request.getRequestDispatcher("/addFood.jsp").forward(request, response);
					return;
				}
			}
			System.out.println("test2");
			food.setId(map.get("id"));
			food.setName(map.get("foodName"));
			food.setTaste(map.get("taste"));
			food.setDescription(map.get("description"));
			food.setPrice(map.get("price"));
			food.setPath(url);
			foodDaoImpl.addFood(food);
			System.out.println(food);
			request.setAttribute("msg", "菜品添加成功");
			request.getRequestDispatcher("/addFood.jsp").forward(request, response);
			return;
		} catch (Exception e) { 
			// TODO: handle exception
			System.out.println(e);
			System.out.println(e.getStackTrace()[0].getLineNumber());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

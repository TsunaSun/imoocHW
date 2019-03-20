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
 * Servlet implementation class FoodUpdateServlet
 */
@WebServlet("/FoodUpdateServlet")
public class FoodUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FoodUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			// 创建磁盘工厂
			DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
			// 创建核心解析项
			ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
			List<FileItem> list = new ArrayList<FileItem>();
			list = (List) servletFileUpload.parseRequest(request);
			Map<String, String> map = new HashMap<String, String>();
			String url = null;
			for (FileItem fileItem : list) {
				if (fileItem.isFormField()) {
					String name = fileItem.getFieldName();
					String value = fileItem.getString("utf-8");
					map.put(name, value);
				} else {
					String name = fileItem.getName();
					if (name != null && name != "") {
						// 生成唯一文件名
						String UUIDname = com.utils.UploadUUID.getUUIDFileName(name);
						InputStream is = fileItem.getInputStream();
						// 创建路径
						String path = this.getServletContext().getRealPath("/Upload");
						System.out.println(path);
						// 创建完整路径
						url = path + "\\" + UUIDname;
						OutputStream os = new FileOutputStream(url);
						int n = 0;
						byte[] b = new byte[1024];
						while ((n = is.read(b)) != -1) {
							os.write(b, 0, n);
						}
						os.close();
						is.close();
					}
					
				}
				
			}
			String id = map.get("id");
			Food food = new Food();
			FoodDaoImpl foodDaoImpl = new FoodDaoImpl();
			food = foodDaoImpl.getFoodById(id);
			if (food == null) {
				String msg = "菜品id不存在";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("/updateFood.jsp").forward(request, response);
				return;
			}
			food.setName(map.get("foodName"));
			food.setPath(url);
			food.setPrice(map.get("price"));
			food.setTaste(map.get("taste"));
			food.setDescription(map.get("description"));
			new FoodDaoImpl().updateFood(food);
			String msg = "修改菜品成功";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/updateFood.jsp").forward(request, response);
			return;	
		} catch (Exception e) {
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

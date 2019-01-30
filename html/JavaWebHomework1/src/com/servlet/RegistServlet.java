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
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.domain.User;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistServlet() {
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
			// 创建磁盘文件工厂
			DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
			// 创建核心解析项
			ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
			//定义List集合存放复选框数据
			List<String> hobbyList = new ArrayList<String>();
			//定义 map 存放临时 注册数据
			Map<String, String> map = new HashMap<String, String>();
			// 解析request请求
			List<FileItem> list = (List<FileItem>)servletFileUpload.parseRequest(request);
			String url = null;
			for (FileItem fileItem : list) {
				//判断是否为文件项
				if (fileItem.isFormField()) {
					String name = fileItem.getFieldName();
					String value = fileItem.getString("utf-8");
					System.out.println(name + value);
					//接受复选框
					if (name.equals("hobby")) {
						String hobby = fileItem.getString("utf-8");
						hobbyList.add(hobby);
						//处理 输出时的 []
						String hobbyValue = hobbyList.toString().substring(1,hobbyList.toString().length()-1);
						System.out.println(hobbyValue);
						map.put(name, hobbyValue);	
					}else {
						map.put(name, value);
					}
				} else {
					// 文件项
					String name = fileItem.getName();
					if (name != null && !name.equals("")) {
						// 生成唯一名称
						String uuidname = com.utils.UploadUUID.getUUIDFileName(name);
						// 创建输入流
						InputStream is = fileItem.getInputStream();
						// 生成路径
						String path = this.getServletContext().getRealPath("/Upload");
						System.out.println(path);
						// 生成整个文件上传的路径
						url = path + "\\" + uuidname;
						// 对接输入输出流
						OutputStream os = new FileOutputStream(url);
						int n = 0;
						byte[] b = new byte[1024];
						while ((n = is.read(b)) != -1) {
							os.write(b, 0, n);
						}
						is.close();
						os.close();
					}
				}
			}
			List<User> userList = (List<User>)this.getServletContext().getAttribute("list");
			for (User user : userList) {
				if (map.get("username").equals(user.getUsername())) {
					request.setAttribute("msg", "用户名已存在！");
					request.getRequestDispatcher("/regist.jsp").forward(request, response);
					return;
				}
			}
			User user = new User();
			user.setUsername(map.get("username"));
			user.setPassword(map.get("password"));
			user.setNickname(map.get("nickname"));
			user.setGender(map.get("sex"));
			user.setHobby(map.get("hobby"));
			user.setPath(url);
			System.out.println(map.get("hobby"));
			userList.add(user);
			for (User user2 : userList) {
				System.out.println(user2);
			}
			this.getServletContext().setAttribute("list", userList);
			//保存注册信息到session
			request.getSession().setAttribute("username", user.getUsername());
			request.setAttribute("username", user.getUsername());
			
			//重定向到 login.jsp
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 遍历集合

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

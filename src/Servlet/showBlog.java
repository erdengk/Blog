package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Db.getBlog;
import User.User;
import User.UserBlog;

public class showBlog extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		getBlog b = new getBlog();
		List<UserBlog> userBlogAll = b.getBlog();
		System.out.println(userBlogAll.toString());
		request.setAttribute("userBlogAll", userBlogAll);
		request.getRequestDispatcher("/home1.jsp").forward(request, response);
	}
}

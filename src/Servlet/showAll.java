package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Db.getUser;
import User.User;

public class showAll extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		getUser u = new getUser();
		List<User> userAll = u.getUser();
		System.out.println(userAll.toString());
		request.setAttribute("userAll", userAll);
		request.getRequestDispatcher("/home.jsp").forward(request, response);
	}
}

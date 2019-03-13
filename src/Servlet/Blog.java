package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Db.getBlog;
import User.User;
import User.UserBlog;

public class Blog extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		User u = new User();
//		u.setUsername("1231231");
//		request.setAttribute("u", u);
		
//		UserBlog ub = new UserBlog();
//		
//		//登录 从 seeion 中取到用户名  和 num
//		//使用 查询 然后将查询到的语句给 对象 set  然后  request   然后显示
//		
//		ub.setUsername("123");
//		ub.setTitle("123");
//		ub.setTxt("64564891");
//		request.setAttribute("ub", ub);
		
		
		try {
			HttpSession session=request.getSession();
			User u= (User) session.getAttribute("u");
			
		
		//得到 登录之后的  seesion 中的 username
		String username=u.getUsername();
		if(username==null)
		{
			username="1";
		}
		else
		{
			getBlog b = new getBlog();
			UserBlog ub =new UserBlog();
			
			String number=request.getParameter("number");
			int num = Integer.valueOf(number);
			
			ub= b.getUserBlog(username,num);
			if (ub!=null)
			{
				request.setAttribute("ub",ub);
				request.getRequestDispatcher("/blog.jsp").forward(request, response);
			}
			else
			{
				System.out.println("查询失败");
			}
		}
		} catch (Exception e) {
			request.getRequestDispatcher("/fail.jsp").forward(request, response);
		}
		

//		System.out.println(userBlogAll.toString());

	}

}

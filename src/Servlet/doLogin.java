package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Db.Find;

public class doLogin extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("text/html;charset=utf-8");
		System.out.println("正常运行   到达servlet   Login");
		String inputusername = request.getParameter("username");
		String inputpassword = request.getParameter("password");
		System.out.println("当前用户"+inputusername);
		System.out.println("当前密码"+inputpassword);
		int b=Find.Find(inputusername, inputpassword);
		String xinxi="信息123xinxi";
		request.setAttribute("message", xinxi);
		if(b==1)
		{
			System.out.println("去往welcome ");
			request.setAttribute(inputusername, "123");
//		    request.setAttribute(“curruser”, curruser);
//			setAttribute这个方法是将curruser这个对象保存在request作用域中，
//			然后在转发进入的页面就可以获取到你的值
			request.getRequestDispatcher("/login/success.jsp").forward(request, response);	
			//request.getRequestDispatcher("/Welcome").forward(request, response);
		}
		else{
			System.out.println("去往fail ");
			request.getRequestDispatcher("/login/fail.jsp").forward(request, response);
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//response.setContentType("text/html");request.setAttribute("message", xinxi);
		//PrintWriter out = response.getWriter();
		//    java 中是 引用传递   
		doGet(request, response);
	}
}

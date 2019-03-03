package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import User.User;
import Db.Adduser;

public class doRegist extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


        response.setContentType("text/html;charset=UTF-8");
        // 仅此一句足矣	

		System.out.println("正常运行   到达servlet   regist");
		String inputusername1 = request.getParameter("username");
		String inputpassword1 = request.getParameter("password");
		String inputemail1 = request.getParameter("email");
		System.out.println("注册");
		System.out.println("当前用户"+inputusername1);
		System.out.println("当前密码"+inputpassword1);
		System.out.println("当前邮箱"+inputemail1);
		
		int b= Adduser.add(inputusername1, inputpassword1,inputemail1);
		if(b==1)
		{
			System.out.println("去往 成功   RegistSuccess ");
			User user = new User(); //实例化一个对象，组装属性
			user.setUsername(inputusername1);
			user.setPassword(inputpassword1);
			user.setEmail(inputemail1);
//		    request.setAttribute(“curruser”, curruser);
//			setAttribute这个方法是将curruser这个对象保存在request作用域中，
//			然后在转发进入的页面就可以获取到你的值
			request.getRequestDispatcher("/login/success.jsp").forward(request, response);	
		}
		else{
			System.out.println("去往fail ");
			request.getRequestDispatcher("/login/fail.jsp").forward(request, response);
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

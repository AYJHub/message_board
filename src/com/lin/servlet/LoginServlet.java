package com.lin.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lin.bean.Message;
import com.lin.bean.User;
import com.lin.dao.LoginDao;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("charset=UTF-8");

		LoginDao dao = new LoginDao();
		HttpSession session = request.getSession();

		User user = (User) request.getSession().getAttribute("login");

		if (user == null) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			user = dao.findUser(username, password);// 查找数据库，用户是否注册
		}

		if (user != null) {
			session.setAttribute("login", user);
			
			//获取留言板中的信息，并放到Session中
			ArrayList<Message> al = dao.findInfo();
			session.setAttribute("al", al);
			
			response.sendRedirect("main.jsp");
		} else {
			response.sendRedirect("error.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

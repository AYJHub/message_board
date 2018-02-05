package com.lin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lin.dao.LoginDao;

public class RegisterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("charset=UTF-8");

		int id = Integer.valueOf(request.getParameter("idnumber"));
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		if (new LoginDao().insertUser(id, name, password)) {

			System.out.println("regist success!");
			response.sendRedirect("login.jsp");
		} else {
			System.err.println("regist error!");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

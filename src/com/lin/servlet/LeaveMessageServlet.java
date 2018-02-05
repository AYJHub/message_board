package com.lin.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lin.bean.Message;
import com.lin.bean.User;
import com.lin.dao.LoginDao;

public class LeaveMessageServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8"); 
		response.setContentType("charset=UTF-8");
		
		String title = request.getParameter("title");
		String message = request.getParameter("message");
	
		User user = (User) request.getSession().getAttribute("login");
		
		Message ms = new Message();
		ms.setId(user.getId());
		ms.setUsername(user.getName());
		ms.setTime(new Date(System.currentTimeMillis()));
		ms.setTitle(title);
		ms.setMessage(message);
		
		if(new LoginDao().addInfo(ms))
		{
			response.sendRedirect("success.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

<%@page import="com.lin.dao.LoginDao"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.lin.bean.Message"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
</head>
<body
	style="background-color: #ddd; margin-left: 41%; font-family: sans-serif">
	<div style="margin-top: 120px">
		<h2>Index of MessageBoard</h2>
		<table style="border: 1;">
			<tr>
				<th>留言人姓名</th>
				<th>留言时间</th>
				<th>留言标题</th>
				<th>留言内容</th>
			</tr>
			<%
				ArrayList<Message> al = new ArrayList();
				al = (ArrayList) session.getAttribute("al");
				if (al != null) {
					Iterator it = al.iterator();
					while (it.hasNext()) {
						Message ms = (Message) it.next();
			%>
			<tr>
				<td><%= new LoginDao().getName(ms.getId()) %></td>
                <td><%= ms.getTime().toString() %></td>
                <td><%= ms.getTitle() %></td>
                <td><%= ms.getMessage() %></td>
			</tr>
			<%
				}
			}
			%>
		</table>
		<a href="leavemessage.jsp">leavemessage</a>
	</div>
</body>
</html>
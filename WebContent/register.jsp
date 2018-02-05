<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>register page</title>
</head>
<body
	style="background-color: #ddd; margin-left: 41%; font-family: sans-serif">
	<div style="margin-top: 120px">
		<h2>Register Please！</h2>
		<form action="registerServlet" method="post">
			<table>
				<tr>
					<td>idnumber</td>
					<td><input name="idnumber" type="text" size="20" /></td>
				</tr>
				<tr>
					<td>username</td>
					<td><input name="username" type="text" size="20" /></td>
				</tr>
				<tr>
					<td>password</td>
					<td><input name="password" type="text" size="20" /></td>
				</tr>
			</table>
			<input type="submit" value="submit" /> <input type="reset"
				value="reset" />
		</form>
		<br> <a href="login.jsp">go login</a>
	</div>
</body>
</html>
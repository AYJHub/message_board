<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login page</title>
</head>
<body style="font-family: sans-serif;margin-left: 41%;background-color: #ddd">
	<div style="margin-top: 120px">
		<h2>Login Please！</h2>
		<form action="loginServlet" method="post">
			<table>
				<tr>
					<td>username</td>
					<td><input name="username" type="text" size="20" /></td>
				</tr>
                <tr>
					<td>password</td>
					<td><input name="password" type="password" size="20" /></td>
				</tr>
			</table>
			<input type="submit" value="submit">
			<input type="reset" value="reset">
		</form>
		<br>
		<a href="register.jsp">go register</a>
	</div>
</body>
</html>
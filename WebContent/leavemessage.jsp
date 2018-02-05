<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color: #ddd; font-family: sans-serif">
	<div style="margin-top: 120px; margin-left: 41%">
		<h2>LeaveMessage!</h2>
		<form action="leaveMessageServlet" method="post">
			<table style="border: 1">
				<tr>
					<td>message title</td>
					<td><input type="text" name="title" /></td>
				</tr>
				<tr>
					<td>message content</td>
					<td><textarea name="message" rows="5" cols="35"></textarea></td>
				</tr>
			</table>
			<input type="submit" value="submit" /> <input type="reset"
				value="reset" />
		</form>
		<a href="main.jsp">go index</a>
	</div>
</body>
</html>
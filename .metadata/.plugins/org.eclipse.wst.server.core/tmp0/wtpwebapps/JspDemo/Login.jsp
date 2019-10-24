<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="get" action="Login.jsp">
<center>
	User name :
	<input type="text" name="user" /></br></br>
	Password :
	<input type="password" name="password" /></br></br>
	<input type="submit" value="Login" />
	<%
	if(request.getParameter("user") != null && request.getParameter("password") != null){
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		if(user.equals("raghu") && password.equals("jerry")){
		%>
		<jsp:forward page="Calc.jsp"></jsp:forward>
		<% 
		} else{
		%>
		<h4 style="color:red;">Wrong Credentials</h4>
	<%}} %>
	</center>
	</form>
</body>
</html>
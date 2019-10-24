<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="get" action="Calc.jsp">
<center>
	<h3 >Welcome to Simple Calculator</h3>
	First no :
	<input type="text" name="first" /></br></br>
	Second no :
	<input type="text" name="second" /></br></br>
	<input type="submit" value="Add" /></br></br>
	<%
	if(request.getParameter("first") != null && request.getParameter("second") != null){
	int a = Integer.parseInt(request.getParameter("first"));
	int b = Integer.parseInt(request.getParameter("second"));
	out.println(a+b);
	}
	%>
</center>
</form>
</body>
</html>
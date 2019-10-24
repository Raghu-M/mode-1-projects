<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.hcl.jsp.DaoConnection"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SearchEmploy</title>
</head>
<body>
<form>
<center>
	Enter Employ Number : 
	<input type="text" name="empno" /></br></br>
	<input type="submit" value="Search" /></br>
	<%
		if(request.getParameter("empno")  != null){
			Connection con = DaoConnection.getconnection();
			String cmd = "Select * from employ where empno = ?";
			PreparedStatement pst = con.prepareStatement(cmd);
			pst.setInt(1, Integer.parseInt(request.getParameter("empno")));
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
	%></br></br></br>
		<table>
		<tr><td>
		Name : </td><td><%=rs.getString("name") %></td></br>
		<tr><td>
		Department : </td><td><%=rs.getString("dept") %></td></br>
		<tr><td>
		Designation :</td><td> <%=rs.getString("desig") %></td></br>
		<tr><td>
		Salary : </td><td><%=rs.getInt("basic") %></td></br>
		</table>
		<% } else out.print("Employ not found");
			}
	%>
</center>
</form>
</body>
</html>
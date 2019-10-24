<%@page import="java.awt.Window"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.oracle.webservices.internal.api.EnvelopeStyle.Style"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.hcl.jsp.DaoConnection"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AddEmploy</title>
</head>
<body>
	<%
		Connection con = DaoConnection.getconnection();
		int empno = 0;
		String cmd =  "select case when max(empno) is null "
				+ "then 1 else max(empno)+1 end emp "
				+ "From employ";
			 PreparedStatement pst  = con.prepareStatement(cmd);
			ResultSet rs = pst.executeQuery();
			rs.next();
			empno = rs.getInt("emp");
 	%>
 <form>
 <center>
 <table bgcolor="green"><tr><td>
 	Employ Number :</td><td>
 	<input type="text" value="<%=empno%>" name="empno" readonly/></td></tr>
 	<tr><td>
 	Name :</td><td>
 	<input type="text" name="name" /></td></tr>
 	<tr><td>
 	Department :</td><td>
 	<input type="text" name="dept" /></td></tr>
 	<tr><td>
 	Designation :</td><td>
 	<input type="text" name="desig" /></td></tr>
 	<tr><td>
 	Salary :</td><td>
 	<input type="text" name="basic" /></td></tr>
 	<tr><td>
 	<a href="ShowEmploy.jsp"></br><input type="button" value="Back to ShowEmploy"/></a></td><td>
 	<a><input type="Submit" value="Insert" /></a></td></tr>
 	
 	</table>
 	
 	<%  
	if(request.getParameter("empno")  != null && request.getParameter("basic") != null){
		 con = DaoConnection.getconnection();
		 cmd = "insert into employ values(?,?,?,?,?)";
		 pst = con.prepareStatement(cmd);
		pst.setInt(1, Integer.parseInt(request.getParameter("empno")));
		pst.setString(2, request.getParameter("name"));
		pst.setString(3, request.getParameter("dept"));
		pst.setString(4, request.getParameter("desig"));
		pst.setInt(5, Integer.parseInt(request.getParameter("basic")));
		pst.executeUpdate();
	%>
	<p>Employ Inserted</p>
	<%
	}%>
</center>
</form>
</body>
</html>
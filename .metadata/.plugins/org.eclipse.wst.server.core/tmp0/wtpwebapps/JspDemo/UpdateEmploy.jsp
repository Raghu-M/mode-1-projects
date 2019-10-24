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
<title>UpdateEmploy</title>
</head>
<body>
<form>
<center>
<%
	int empno = Integer.parseInt(request.getParameter("empno"));
	String dept = request.getParameter("dept");
	String desig = request.getParameter("desig");
	int basic = Integer.parseInt(request.getParameter("basic"));
%>
<table bgcolor="purple">
	<tr><td>
	Employ Number :</td><td>
 	<input type="text" name="empno" value="<%=empno %>" readonly/></td></tr>
 	<tr><td>
 	Department :</td><td>
 	<input type="text" name="dept"  value="<%=dept %>"/></td></tr>
 	<tr><td>
 	Designation :</td><td>
 	<input type="text" name="desig" value="<%=desig %>"/></td></tr>
 	<tr><td>
 	Salary :</td><td>
 	<input type="text" name="basic" value="<%=basic %>"/></td></tr>
 	<tr><td>
 	<a href="ShowEmploy.jsp"></br><input type="button" value="Back to ShowEmploy"/></a></td><td>
 	<a><input type="Submit" value="Update" /></a></td></tr>
 	</table>
 	<%
	if(request.getParameter("empno")  != null && request.getParameter("basic") != null){
		Connection con = DaoConnection.getconnection();
		String cmd = "Select empno from employ where empno=?";
		PreparedStatement pst = con.prepareStatement(cmd);
		pst.setInt(1, Integer.parseInt(request.getParameter("empno")));
		ResultSet rs = pst.executeQuery();
		if(rs.next()){
		cmd = "update employ set dept=?, desig=?, basic=? where empno =?";
		pst = con.prepareStatement(cmd);
		pst.setString(1, request.getParameter("dept"));
		pst.setString(2, request.getParameter("desig"));
		pst.setInt(3, Integer.parseInt(request.getParameter("basic")));
		pst.setInt(4, Integer.parseInt(request.getParameter("empno")));
		pst.executeUpdate();
		}
	}
	%>


</center>
</form>
</body>
</html>
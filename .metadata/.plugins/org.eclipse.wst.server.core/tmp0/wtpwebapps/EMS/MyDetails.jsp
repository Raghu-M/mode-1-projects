<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.hcl.ems.DaoConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		Connection con = DaoConnection.getConnection();
		PreparedStatement pst;
		int emp_id = 1000;
		String cmd = "select * from employee where emp_id = ?";
		pst = con.prepareStatement(cmd);
		pst.setInt(1, emp_id);
		ResultSet rs = pst.executeQuery();
		rs.next();
	%>
	   <h2> My Details Section </h2>
	   Employee ID : 
	   <%=rs.getInt("emp_id") %><br/><br/>
	   Full Name :
	   <%=rs.getString("Emp_name") %><br/><br/>
	   Email Address :
	    <%=rs.getString("Emp_email") %><br/><br/>
	   Mobile Number :
	    <%=rs.getString("Emp_Mob_No") %><br/><br/>
	   Date joined :
	    <%=rs.getString("Emp_Dpt_") %><br/><br/>
</body>
</html>
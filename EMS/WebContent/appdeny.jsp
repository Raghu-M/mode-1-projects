<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.hcl.ems.DaoConnection"%>
<%@page import="java.sql.Connection"%>
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
	String cmd = "select * from LEAVE_HISTORY where LEA_ID = ?";
	PreparedStatement pst = con.prepareStatement(cmd);
	pst.setInt(1, Integer.parseInt(request.getParameter("id")));
	ResultSet rs = pst.executeQuery();
	rs.next();
	if(request.getParameter("status").equals("DENIED")){
		cmd = "update EMPLOYEE set Emp_leave_balance = Emp_leave_balance+? where EMP_ID=?";
		pst = con.prepareStatement(cmd);
		pst.setInt(1, rs.getInt("LEA_NO_OF_DAYS"));
		pst.setInt(2,rs.getInt("EMP_ID"));
		pst.executeUpdate();
		
		cmd = "update LEAVE_HISTORY set LEA_STATUS = 'DENIED' where LEA_ID = ?";
		pst = con.prepareStatement(cmd);
		pst.setInt(1,rs.getInt("LEA_ID"));
		pst.executeUpdate();
		
	}
	if(request.getParameter("status").equals("APPROVED")){
		cmd = "update LEAVE_HISTORY set LEA_STATUS = 'APPROVED' where LEA_ID = ?";
		pst = con.prepareStatement(cmd);
		pst.setInt(1,rs.getInt("LEA_ID"));
		pst.executeUpdate();
	}
%>
<jsp:forward page="DashBoard.jsp"></jsp:forward>
</body>
</html>
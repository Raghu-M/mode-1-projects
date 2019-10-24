<%@page import="java.sql.ResultSet"%>
<%@page import="com.hcl.library.DaoConnection"%>
<%@page import="java.sql.PreparedStatement"%>
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
<form>
<%
	String bkid [] = request.getParameterValues("ckid");
	String user = (String)session.getAttribute("user");
	if(bkid != null){
		Connection con;
		String cmd;
		PreparedStatement pst;
	for (String i : bkid) {
		con = DaoConnection.getconnection();
		cmd = "select Fromdate from TranBook where BookId =? and username=?";
		pst = con.prepareStatement(cmd);
		pst.setInt(1, Integer.parseInt(i));
		pst.setString(2, user);
		ResultSet rs = pst.executeQuery();
		rs.next();

		con = DaoConnection.getconnection();
		cmd = "insert into TransReturn (username,bookId,FromDate) values(?,?,?)";
		pst = con.prepareStatement(cmd);
		pst.setString(1, user);
		pst.setInt(2, Integer.parseInt(i));
		pst.setString(3,  rs.getString("FromDate"));
		pst.executeUpdate();
		
		con = DaoConnection.getconnection();
		cmd = "Delete from TranBook where BookId =?  and username=?";
		pst = con.prepareStatement(cmd);
		pst.setInt(1, Integer.parseInt(i));
		pst.setString(2, user);
		pst.executeUpdate();
		
		con = DaoConnection.getconnection();
		cmd = "update books set totalbooks = totalbooks+1 where Id =?";
		pst = con.prepareStatement(cmd);
		pst.setInt(1, Integer.parseInt(i));
		pst.executeUpdate();
		
	
	}
	}
	
%>
	<jsp:forward page="Menu.jsp"></jsp:forward>
</form>
</body>
</html>
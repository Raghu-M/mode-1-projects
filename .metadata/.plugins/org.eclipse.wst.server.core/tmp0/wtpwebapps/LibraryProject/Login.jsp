<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.hcl.library.DaoConnection"%>
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
<center>
   <table bgcolor="orange"><tr><th colspan="2">Login</th></tr><tr><td>
	UserName :</td><td>
	<input type="text" name="user" /></td></tr>
	<tr><td>
	Password :</td><td>
	<input type="password" name="password" /></td></tr>
	<tr><td colspan="2">
	<input type="submit" value="Login" style="width: 253px; color: Green"/></td></tr>
	</table>
	<%
	if(request.getParameter("user") != null){
	 String user = request.getParameter("user");
	 String password = request.getParameter("password");
	 Connection con = DaoConnection.getconnection();
	 String cmd = "select password from LibUsers where username = ?";
	 PreparedStatement pst = con.prepareStatement(cmd);
	 pst.setString(1, user);
	 ResultSet rs = pst.executeQuery();
		session.setAttribute("user", user);
	 if(rs.next()){
		 if(password.equals(rs.getString("password"))){%>
			 <jsp:forward page="Menu.jsp?name=<%=user %>"></jsp:forward>
		<% } else {%>
			 <a style="color:red">Wrong Password</a>
		<% }
	 } else {%>
		 <a style="color:red">user does not exist </a>
	<%  }
	}
	 
	%>
</center>
 		
</form>
</body>
</html>
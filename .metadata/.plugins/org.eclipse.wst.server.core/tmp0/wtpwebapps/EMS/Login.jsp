<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.hcl.ems.DaoConnection"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
function cancel(){
	document.getElementById('user').value="";
	document.getElementById('password').value="";
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center></br></br><br/></br></br><br/>
	<form>
	<table bgcolor="orange"><tr><td>
		Employee ID :</td><td>
		<input type = "number" name = "EMP_ID" id="user" />
		<tr><td>
		Password :</td><td>
		<input type = "password" name = "password"  id="password"/></td></tr>
		<tr><td>
		<input type = "submit" value = "LOGIN" /></td><td>
		<input type = "button" value = "CANCEL" onclick="cancel()"/></td></tr>
		</table>
	</form>
	
	<%
		String EMP_ID = (String)request.getParameter("EMP_ID");
		String password = (String)request.getParameter("password");
		
	if(request.getParameter("EMP_ID") != null) {
		session.setAttribute("EMP_ID", EMP_ID);
		Connection con = DaoConnection.getConnection();
		String cmd = "Select SecretCode from EmployLogin where EMP_ID = ?";
		PreparedStatement pst = con.prepareStatement(cmd);
		pst.setInt(1, Integer.parseInt(EMP_ID));
		ResultSet rs = pst.executeQuery();
		if(rs.next()){
			if(rs.getString("SecretCode").equals(password)){
				%> <jsp:forward page="DashBoard.jsp"></jsp:forward> <% 
			} else {%>
						 <a style="color:red">Wrong Password</a>
			<%}
		}else {%>
		 <a style="color:red">Employ does exist not </a>
	<%  }
	}
	%>
	</center>
</body>
</html>
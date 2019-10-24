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
<title>ShowEmploy</title>
</head>
<body>
<center><table >
<tr style="color:red" bgcolor="yellow" border="1"><td>Empno </td><td>Name</td><td>Department</td>
	<td>Designation</td><td>Salary</td><td>Update</td><td>Delete</td></tr>
	<%
		Connection con = DaoConnection.getconnection();
		String cmd = "select * from Employ where empno";
		PreparedStatement pst = con.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		while(rs.next()){
	%>
	<tr bgcolor="orange">
		<td><%=rs.getInt("empno") %></td>
		<td><%=rs.getString("name") %></td>
		<td><%=rs.getString("dept") %></td>
		<td><%=rs.getString("desig") %></td>
		<td><%=rs.getInt("basic") %></td>
		<td><a href="UpdateEmploy.jsp?empno=<%=rs.getInt("empno")%>&dept=<%=rs.getString("dept")%>
				&desig=<%=rs.getString("desig")%>&basic=<%=rs.getInt("basic")%>">Update</a></td>
		<td><a href="DeleteEmploy.jsp?empno=<%=rs.getInt("empno")%>">Delete</a></td></tr>
	<%} %>
</table>
<a href="InsertEmploy.jsp"></br><input type="button" value="Add Employ"/></a>
</center>
</body>
</html>
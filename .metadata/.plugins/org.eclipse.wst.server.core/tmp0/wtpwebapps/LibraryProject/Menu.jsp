<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.hcl.library.DaoConnection"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
function search(){
	var x = document.getElementById('search');
	if(x.style.visibility === 'hidden'){
		x.style.visibility = 'visible';
	} else {	
		x.style.visibility = 'hidden';
	}
}
function issue(){
	var x = document.getElementById('issueBook');
	if(x.style.visibility === 'hidden'){
		x.style.visibility = 'visible';
	} else {	
		x.style.visibility = 'hidden';
	}
}
function Return(){
	var x = document.getElementById('Return');
	if(x.style.visibility === 'hidden'){
		x.style.visibility = 'visible';
	} else {	
		x.style.visibility = 'hidden';
	}
}

function myfunction(){
	var x = document.getElementById('submit');
	var y = document.getElementsByName("ckid");
	var count = 0;
	for(var i=0;i<y.length;i++){
		if(y[i].checked){
			count++;
		} 
	}
	if(count==0){
		x.disabled = true;
	} else {
		x.disabled = false;
	}
	
}

</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
		<%String user = (String) session.getAttribute("user") ;%>
		<a>Welcome : <%=user%></a>
		<a href = "Login.jsp"><input type="button" value="Logout" /></a>
	<table bgcolor="yellow" Style="color:purple; width: 586px">
		<tr><th><a>Account Details</a></th>
		<th><input type="button" value="Search Books" onclick="search()"></a></th>
		<th><input type="button" value="Issued Book" onclick="issue()"></a></th>
		<th><input type="button" value="Return History" onclick="Return()"></a></th></tr></table>
		
	</center>
	
	
	<div id="search" style="visibility: hidden; position: absolute; top: 100px; left: 100px">

		<form action="Search.jsp">
		<table bgcolor="green">
		<tr><td>
		<input type="radio" name="search" value="author" /> Author</td></tr>
		<tr><td>
	 	<input type="radio" name="search" value="name" />Book Name</td></tr>
	 	<tr><td>
		<input type="radio" name="search" value="all" checked /> All Books</td></tr>
		<tr><td>
		<input type="radio" name="search" value="dept" /> Department</td></tr>
		<tr><td>
		<input type="radio" name="search" value="id" />	Book ID</td></tr>
		<tr><td>
		<input type="text" name="searchbook" /></td></tr>
		<tr><td>
		<%String radio = request.getParameter("search");
		  String text = request.getParameter("searchbook");%>
		<a href="Search.jsp?search=<%=radio%>&searchbook=<%=text%>"><input type="submit" Value="searchBook" style="width: 173px;" /></a></td></tr>
		</table>
		</form>
		</div>
		
<div id = "issueBook" style="visibility: hidden; position: absolute; top: 100px; left: 500px">
	<form action="Return.jsp">
	<center>
	<%
		user = (String)session.getAttribute("user");
		Connection con = DaoConnection.getconnection();
		PreparedStatement pst;
		ResultSet rs;
		String cmd = "Select * from  TranBook where Username =?";
		pst= con.prepareStatement(cmd);
		pst.setString(1, user);
		rs = pst.executeQuery();
		%><table><tr style="color:red" bgcolor="yellow"><td>Book ID </td><td>Taken At</td><td>Return</td></tr><%
		while(rs.next()){
			%>
			<tr bgcolor="orange">
				<td><%=rs.getInt("BookId") %></td>
				<td><%=rs.getString("Fromdate") %></td>
				<td><input type="checkbox" name="ckid" value=<%=rs.getInt("BookId")%> onchange="myfunction()" /></td></tr>
		<%
		}
	%><tr><td>
	
	<input type="submit" id="submit" value="Return Book" disabled/></td></tr>
	</table>
	</center>
	</form>
</div>



<div id = "Return" style="visibility: hidden; position: absolute; top: 100px; left: 1000px">
<center>
<%
	
	con = DaoConnection.getconnection();
	cmd = "select * from transReturn where username = ?";
	pst = con.prepareStatement(cmd);
	pst.setString(1, user);
	rs = pst.executeQuery();
	%>
	<table><tr style="color:red" bgcolor="yellow"><td>Book ID </td><td>From Date</td><td>To Date</td></tr>
	<%
	while(rs.next()){
		%>
		<tr bgcolor="orange">
			<td><%=rs.getInt("bookid") %></td>
			<td><%=rs.getString("Fromdate") %></td>
			<td><%=rs.getString("Todate") %></td>
			</tr>
			
		<%} %>

</table>
</center>
</body>
</html>
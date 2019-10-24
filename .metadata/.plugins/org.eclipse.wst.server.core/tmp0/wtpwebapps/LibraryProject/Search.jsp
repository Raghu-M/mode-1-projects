<%@page import="javax.websocket.OnClose"%>
<%@page import="java.io.UncheckedIOException"%>
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
<%  String search = request.getParameter("search");
	String searchbk = request.getParameter("searchbook");
	String user = (String)session.getAttribute("user");
	Connection con = DaoConnection.getconnection();
	String cmd = null;
	PreparedStatement pst = null;
	ResultSet rs =null,res=null;
	if(search.equals("author")){
		cmd = "select * from books where author = ?";
	 	pst = con.prepareStatement(cmd);
		pst.setString(1, searchbk);
		rs = pst.executeQuery();
	} else if(search.equals("name")){
		cmd = "select * from books where name = ?";
		pst = con.prepareStatement(cmd);
		pst.setString(1, searchbk);
		rs = pst.executeQuery();
	} else if(search.equals("dept")){
		cmd = "select * from books where Dept = ?";
		pst = con.prepareStatement(cmd);
		pst.setString(1, searchbk);
		rs = pst.executeQuery();
	} else if(search.equals("id")){
		cmd = "select * from books where id = ?";
		pst = con.prepareStatement(cmd);
		pst.setInt(1, Integer.parseInt(searchbk));
		rs = pst.executeQuery();
	} else if(search.equals("all")){
		cmd = "select * from books ";
		pst = con.prepareStatement(cmd);
		rs = pst.executeQuery();
	} %>
	<form action="Borrow.jsp">
	<%=user %>
	<table>
	<tr style="color:red" bgcolor="yellow"><td>Book ID </td><td>Name</td><td>Author</td>
	<td>Edition</td><td>Department</td><td>TotalBooks</td><td>borrow</td></tr>
	<% 
	cmd = "select BookId from TranBook where Username = ? ";
	pst = con.prepareStatement(cmd);
	pst.setString(1, user);
	res = pst.executeQuery();
	while(rs.next()){
		if(rs.getInt("totalBooks")!= 0){
		%>
		<tr bgcolor="orange">
			<td><%=rs.getInt("id") %></td>
			<td><%=rs.getString("name") %></td>
			<td><%=rs.getString("author") %></td>
			<td><%=rs.getString("edition") %></td>
			<td><%=rs.getString("dept") %></td>
			<td><%=rs.getInt("totalBooks") %></td>
			<%if(rs.getInt("totalBooks")==0){ %>
			<td><input type="checkbox" name="ckid" disabled /></td>
			<%}else %><td><input type="checkbox"  name="ckid" value=<%=rs.getInt("id")%> onchange="myfunction()"/></td>
			</tr>
		<%} 
		}%>
	
</table></br>
<a  href="Menu.jsp"><input type="button" value="back to menu" /></a>
<input type="submit"  id ="submit" value="borrow book"  disabled/>

</form>
</center>
</body>
</html>
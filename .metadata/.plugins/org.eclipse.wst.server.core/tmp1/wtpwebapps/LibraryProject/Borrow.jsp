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
	<center>
		<%
	
	Connection con = DaoConnection.getconnection();
String bkid[] = request.getParameterValues("ckid");
	if(bkid == null){
		%>
		please Select the Book<%
	}
	else{
	String user  = (String) session.getAttribute("user");
	PreparedStatement pst =null;
	String cmd = "select count(BookId) count from TranBook where Username = ?";
	pst = con.prepareStatement(cmd);
	pst.setString(1, user);
	ResultSet rs = pst.executeQuery();
	rs.next();
	int count = rs.getInt("count");
	boolean flag = false;
	cmd = "select BookId from TranBook where Username = ?";
	pst = con.prepareStatement(cmd);
	pst.setString(1, user);
	rs = pst.executeQuery();
	int id[]={0,0,0},j=0;
	while(rs.next()){
		id[j] = rs.getInt("BookId");
		j++;
	}
	for(String k : bkid){
		for(int i : id) {
			if(i== Integer.parseInt(k)){
				flag=true;
				break;
			}
		}
	}
	if(flag == false){
		if(count+bkid.length<=3){
			for(String i : bkid){
			cmd = "update books set TotalBooks = TotalBooks-1 where id = ?";
			pst = con.prepareStatement(cmd);
			pst.setInt(1, Integer.parseInt(i));
			pst.executeUpdate();
			}
			
			for(String i : bkid){
				cmd = "insert into TranBook(Username,BookId) values(?,?)";
				pst = con.prepareStatement(cmd);
				pst.setString(1, user);
				pst.setInt(2, Integer.parseInt(i));
				pst.executeUpdate();
				}
			%>BOOK BORROWED</br>
		<a href="Menu.jsp"><input type="button" value="Back To Books" /></a>
		<%
		} else {
			%>You Have Max Book</br>
		<a href="Menu.jsp"><input type="button" value="Back To Books" /></a>
		<% 
		}
	} else { %>YOU Already Have One Of The Book</br>
		<a href="Menu.jsp"><input type="button" value="Back To Books" /></a>
		<%
		
	}
	}
%>
	</center>
</body>
</html>
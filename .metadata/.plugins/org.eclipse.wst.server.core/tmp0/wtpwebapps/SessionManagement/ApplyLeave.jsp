<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <form method="get" action="ApplyLeave.jsp">
 <center>
 Start Date:
  <input type="date" placeholder="yyyy-mm-dd" name="startdate"/> <br/><br/>
 End Date:
 <input type="date" name="endadte"/> <br/><br/>
 Number Of Days :
 <input type="text" name="numberofdays"/> <br/><br/>
 Leave Type :
 <select name="leavetype">
  <option value="earned leave">Earned Leave</option> 
 </select> <br/><br/>
 Leave Reason :
 <input type="text" name="leavereason"/> <br/><br/>
 <input type="submit" value="Apply" onclick="Dashboard.html"/>
 <%-- <%
     Connection con=daoconnection.getConnection();
     String cmd="insert into LEAVE_HISTORY values(?,?,?,?,?)";
     PreparedStatement pst=con.prepareStatement(cmd);
     pst.setInt(1,Integer.parseInt(request.getParameter("startdate")));
     pst.setInt(1,Integer.parseInt(request.getParameter("enddate")));
     
 %> --%>
 </center>
</form>
</body>
</html>
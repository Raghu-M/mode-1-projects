<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.hcl.ems.DaoConnection"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>
<%@page import="com.hcl.ems.LeaveHistory"%>
<%@page import="com.hcl.ems.EmployeeBaL"%>
<%@page import="com.hcl.ems.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<head>
<script>
	function selectall(){
		var y = document.getElementsByName("aprove");
		for(var i=0;i<y.length;i++){
			y[i].checked = true;
		}
	}
</script>
</head>
<%  
	String emp_id =(String) session.getAttribute("EMP_ID");
	Connection con = DaoConnection.getConnection();
	String cmd = "select EMP_ID from Employee where EMP_MGR_ID =?";
	PreparedStatement pst = con.prepareStatement(cmd);
	pst.setInt(1, Integer.parseInt(emp_id));
	ResultSet rs = pst.executeQuery();
	while(rs.next()){	
	Employee obj = EmployeeBaL.showEmployeeBal(rs.getInt("Emp_id"));
	List<LeaveHistory> lst = EmployeeBaL.leaveBal(rs.getInt("Emp_id"));
	
%>
<body><form><center style="font-size: 16px; font-family: Tahoma, Verdana, Arial, Sans-Serif">
<table style='font-family: "Trebuchet MS", Sans-Serif; font-size: 14px'>
	<tr bgcolor="#2873C4" style="color :white;">
		<th colspan="2" style="width: 118px; "><center>Employee Id</center></th>
		<td style="width: 106px; "><center><%=obj.getEmp_id() %></center></td>
		<th colspan="2" style="width: 208px; "><center>Employee Name</center></th>
		<td colspan="2" style="width: 85px; height: 38px"><center><%=obj.getEmp_name() %></center></td>
		<th colspan="2" style="width: 385px; "><center style="width: 428px; ">Employee Leave Balance</center></th>
		<td colspan="2" style="width: 94px; "><center><%=obj.getEmp_leave_balance() %></center></td>
	</tr>
	<tr bgcolor="#D0D6F5" style="height: 40px; ">
		<th style="width: 40px; background-color: Gray"></th>
		<th style="width: 91px; "><center>Leave Id</center></th>
		<th style="width: 107px; "><center>Number of days</center></th>
		<th style="width: 96px; "><center>Start Date</center> </th>
		<th style="width: 92px; "><center>End Date</center></th>
		<th style="width: 91px; "><center>Leave Type</center> </th>
		<th style="width: 96px; height: 46px"><center>Status </center></th>
		<th style="width: 231px;"><center style="width: 240px; ">Reason</center></th>
		<th style="width: 161px; ">Comments</th>
		<th style="width: 92px; ">Approve</th>
		<th style="width: 90px; ">Deny</th>
		
	</tr>
	<% for(LeaveHistory i : lst){
	      if(i.getLEA_STATUS().equals("PENDING")){%>
	<tr bgcolor="#EDEFF9" style="height: 40px; ">
		<td style="width: 38px; background-color: Gray"></td>
		<td ><center><%=i.getLEA_ID() %></center></td>
		<td ><center><%=i.getLEA_NO_OF_DAYS() %></center></td>
		<td ><center><%=i.getLEA_START_DATE() %></center> </td>
		<td><center><%=i.getLEA_END_DATE() %></center></td>
		<td ><center><%=i.getLEA_TYPE()%></center> </td>
		<td style="width: 64px; "><center><%=i.getLEA_STATUS() %></center></td>
		<td style="width: 197px;" ><center style="width: 240px; "><%=i.getLEA_REASON()%></center></td>
		<td><input type="text" name="comments" /></td>
		<td><center><a href = "appdeny.jsp?id=<%=i.getLEA_ID() %>&status=APPROVED&comments" ><input type="button"  name=<%=i.getLEA_ID() %> value="Approve"/></a></center></td>
		<td><center><a href = "appdeny.jsp?id=<%=i.getLEA_ID() %>&status=DENIED&comments" ><input type="button"  name=<%=i.getLEA_ID() %> value="Deny"/></a></center></td>
		</tr><%} }%>
</table></br>
</center>
<%
	} %>
</form>
<center><a href="DashBoard.jsp" ><input type="button" value="Back To DashBoard" /> </a></center>
</body>

</html>
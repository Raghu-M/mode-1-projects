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
<head><style type="text/css">
      .scrollable {
        height: 100px;
        overflow-y: scroll;
        overflow-x: scroll;
      }
    </style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<div id="MyDetails" style=" position: absolute; top: 52px; left: 170px; border: 3px solid black; width: 600px; height: 134px; background-color: #D0D6F5;">
<%
	String emp_id =(String) session.getAttribute("EMP_ID");
	Employee obj = EmployeeBaL.showEmployeeBal(Integer.parseInt(emp_id));
%>
<table style='font-size: 13px; font-family: Verdana, Arial, Sans-Serif'><tr bgcolor="#D0D6F5" ><th >
	Employ ID :</td><td style="width: 119px; height: 27px">
	<%=obj.getEmp_id() %></th><th >
	Mobile Number :</th><td >	
	<%=obj.getEmp_mob_no() %></td></tr>
	<tr bgcolor="#EDEFF9" ><th style="width: 115px; ">
	Full Name :</th><td style="height: 27px; width: 250px">
	<%=obj.getEmp_name() %></td><th style="width: 115px; ">
	Date Joined :</th><td style="width: 105px; ">
	<%=obj.getEmp_date_joined() %></td></tr>
	<tr bgcolor="#D0D6F5"><th style="width: 131px; ">
	Email Address :</th><td style="width: 160px; height: 27px">
	<%=obj.getEmp_email() %></td><th>
	Department :</th><td style="width: 89px; ">
	<%=obj.getEmp_dpt_name() %></td></tr>
	<tr bgcolor="#EDEFF9" ><td colspan="4" style="width: 480px; height: 26px"><center>
	Available leave Balance :
	<a style="color : red; font-size: 18px;"><%=obj.getEmp_leave_balance() %></a></center></td></tr>
</table>
</div>



<div id="MyManager" style="border: 3px solid black; position: absolute; top: 52px; left: 780px; width : 390px;height: 134px; background-color: #D0D6F5;" >
	<%
	int emp_id1 = obj.getEmp_mgr_id();
	Employee obj1 = EmployeeBaL.showEmployeeBal(emp_id1);
	if (obj1.getEmp_name()==null) {
	%><table  style="width: 380px;height:107px; font-size: 24px; font-family: Verdana, Arial, Sans-Serif"><tr><td></td><td></td></tr><tr></tr><tr><td> <center><%="No manager" %></td> </tr><tr></tr> </center></table>
	<%
	} else {
	%> <table  style="width: 390px; font-size: 13px; font-family: Verdana, Arial, Sans-Serif"><tr bgcolor="#EDEFF9" style="height: 30px"><th>
	Manager Id :</th><td>
	<%=obj1.getEmp_id() %></td></tr>
	<tr bgcolor="#D0D6F5" style="height: 30px"><th>
	Full Name :</th><td>
	<%=obj1.getEmp_name() %></td></tr>
	<tr bgcolor="#EDEFF9" style="height: 30px"><th>
	Email Address :</th><td>
	<%=obj1.getEmp_email() %></td></tr>
	<tr bgcolor="#D0D6F5" style="height: 30px"><th>
	Mobile Number :</th><td>
	<%=obj1.getEmp_mob_no() %></td></tr>
	<%
	}
	%>
	</table>
</div >




<div class="scrollable" id = " myLeave" style="border: 3px solid black; position:absolute; top: 195px; left: 172px; width : 997px; height : 170px;" >
	<%
	List<LeaveHistory> lst = EmployeeBaL.leaveBal(Integer.parseInt(emp_id));
	%><table  style="width: 997px; font-size: 12px; font-family: Verdana, Arial, Sans-Serif"><tr bgcolor="#2873C4" style="color :white;"><td>Leave ID</td><td>Number of Days</td><td>Start Date</td><td>End Date</td><td>LeaveType</td>
		<td>Status</td><td>Reason</td><td>Applied On</td><td>Manager Comments</td></tr>	
	<tr bgcolor="#D0D6F5"><td colspan="9"><center><a href="ApplyLeave.jsp"><input type="button" value="NEW Leave" /></a></center></td></tr>
	<%
	if(lst != null){
		for(LeaveHistory leave : lst){
		
			%><tr bgcolor="#D0D6F5"><td><%= leave.getLEA_ID()%></td><td><%= leave.getLEA_NO_OF_DAYS()%></td><td><%= leave.getLEA_START_DATE()%></td><td>
			<%= leave.getLEA_END_DATE()%></td><td><%= leave.getLEA_TYPE()%></td><td>
			<%if(leave.getLEA_STATUS().equals("APPROVED")){%>
			<a style="color: green" ><%= leave.getLEA_STATUS()%></a>
			<% }else if(leave.getLEA_STATUS().equals("DENIED")){ %>
			<a style="color: Red" ><%= leave.getLEA_STATUS()%></a>
			<% } else{%>
			 <%= leave.getLEA_STATUS()%> 
			<% }%></td><td><%=leave.getLEA_REASON() %></td><td><%= leave.getLEA_APPLIED_ON()%></td><td><%= leave.getLEA_MGR_COMMENTS()%></td></tr> <%
		}
	} else {
		%><tr><td colspan="9"><center> No Leave History Found</center></td></tr> <%
	}
	%>
	
	</table>
	
</div >



	
<div class="scrollable" id = "EmpLeave" style="border: 3px solid black; position:absolute; top: 375px; left: 170px; width : 998px; height : 210px;">
	<%  
	Connection con  = DaoConnection.getConnection();
	String cmd = "select EMP_ID from Employee where EMP_MGR_ID =?";
	PreparedStatement pst = con.prepareStatement(cmd);
	pst.setInt(1, Integer.parseInt(emp_id));
	ResultSet rs = pst.executeQuery();
	while(rs.next()){	
	Employee obj2 = EmployeeBaL.showEmployeeBal(rs.getInt("Emp_id"));
	List<LeaveHistory> lst1 = EmployeeBaL.leaveBal(rs.getInt("Emp_id"));
	
%>
<form id="myform" method="get"><center style="font-size: 16px; font-family: Tahoma, Verdana, Arial, Sans-Serif">
<table style='font-family: Verdana, Arial, Sans-Serif; font-size: 12px'>
	<tr bgcolor="#2873C4" style="color :white;">
		<th colspan="2" style="width: 118px; "><center>Employee Id</center></th>
		<td style="width: 106px; "><center><%=obj2.getEmp_id() %></center></td>
		<th colspan="2" style="width: 208px; "><center>Employee Name</center></th>
		<td colspan="2" style="width: 85px; height: 38px"><center><%=obj2.getEmp_name() %></center></td>
		<th colspan="2" style="width: 385px; "><center style="width: 428px; ">Employee Leave Balance</center></th>
		<td colspan="2" style="width: 94px; "><center><%=obj2.getEmp_leave_balance() %></center></td>
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
	<% for(LeaveHistory i : lst1){
	      if(i.getLEA_STATUS().equals("PENDING")){%>
	<tr bgcolor="#EDEFF9" style="height: 40px; ">
		<td style="width: 38px; background-color: Gray"></td>
		<td ><center><input type="hidden" name="id" value=<%=i.getLEA_ID() %> /><%=i.getLEA_ID() %></center></td>
		<td ><center><%=i.getLEA_NO_OF_DAYS() %></center></td>
		<td ><center><%=i.getLEA_START_DATE() %></center> </td>
		<td><center><%=i.getLEA_END_DATE() %></center></td>
		<td ><center><%=i.getLEA_TYPE()%></center> </td>
		<td style="width: 64px; "><center><%=i.getLEA_STATUS() %></center></td>
		<td style="width: 197px;" ><center style="width: 240px; "><%=i.getLEA_REASON()%></center></td>
		<td><input type="text" name="comments" /></td>
		<td><center><input type="submit" value="Approve" form="myform" formaction="approve.jsp"/></center></td>
		<td><center><input type="submit"  value="Deny" form="myform" formaction="deny.jsp"/></center></td>
		</tr><%} }%>
</table></br>
</center>
<%
	} %>
</form>
</div>
<center><a href="Login.jsp" ><input type="button" value="Logout" /> </a></center>
</body>
</html>
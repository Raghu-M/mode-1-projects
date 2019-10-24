<%@page import="com.hcl.ems.EmployeeBaL"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.hcl.ems.LeaveHistory"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
	function cancel() {
		document.getElementById("startdate").value = "";
		document.getElementById("enddate").value = "";
		document.getElementById("days").value = "";
		document.getElementById("leavereason").value = "";
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form>
	<center><br><br><br><br><br><br>
		<table>
			<tr bgcolor="#D0D6F5" style="height: 40px">
				<td >Start Date :</td>
				<td><center><input type = "date" name = "startdate" id = "startdate"/></center></td> 
			</tr>
			<tr bgcolor="#2873C4" style="height: 40px; color :white;">
				<td>End Date :</td>
				<td><center><input type = "date" name = "enddate" id = "enddate"/></center></td>
			</tr>
			<tr bgcolor="#D0D6F5" style="height: 40px">
				<td>Number Of Days :</td>
				<td><center><input type = "number" name = "days" id = "days"/></center></td>
			</tr>
			<tr bgcolor="#2873C4" style="height: 40px; color :white;">
				<td style="width: 199px; ">Leave Type :</td>
				<td style="width: 209px; "><center><select name = "leavetype">
					<option value = "EL" >Earned Leave</option>
					<option value = "restricted" >Restricted Leave</option>
				</select></center></td>
				
			</tr>
			<tr bgcolor="#D0D6F5" style="height: 40px">
				<td>Leave Reason :</td>
				<td><center><input type = "text" name = "leavereason" id = "leavereason"/></center></td>
			</tr>
			<tr bgcolor="#2873C4" style="height: 40px">
				<td><center><a href="DashBoard.jsp" ><input type = "button" value = "Back to DashBoard" /></a></center></td>
				<td><center><input type = "button" value = "Cancel" onclick = "cancel()"/></center></td>
			</tr>	
			<tr bgcolor="#D0D6F5" style="height: 40px">
				<td colspan="2"><center><input type = "submit" value = "Apply" /></center></td>
			</tr>
		</table>
	</center>
</form><br><br>


	<% 
	String EMP_ID  = (String)session.getAttribute("EMP_ID");
	if(request.getParameter("leavereason") != null){
		LeaveHistory obj = new LeaveHistory();
		obj.setEMP_ID(Integer.parseInt(EMP_ID));
		if(EMP_ID.equals("1000")){
			obj.setLEA_STATUS("APPROVED");
		} else {
			obj.setLEA_STATUS("PENDING");
		}
		obj.setLEA_MGR_COMMENTS("null");
		obj.setLEA_START_DATE(request.getParameter("startdate"));
		obj.setLEA_END_DATE(request.getParameter("enddate"));
		obj.setLEA_TYPE(request.getParameter("leavetype"));
		obj.setLEA_REASON(request.getParameter("leavereason"));
		String msg = EmployeeBaL.applyLeaveBal(obj);
		if(msg.equalsIgnoreCase("Leave Applied Successfully")){
		%><center><a style="color: green; font-weight: bolder; font-size: 18px; "> <%=msg%></a></center><%
		} else {
			%><center><a style="color: red; font-weight: bolder; font-size: 18px; "><%=msg%></center></a><%
		}
	} 

	%> 

</body>
</html>
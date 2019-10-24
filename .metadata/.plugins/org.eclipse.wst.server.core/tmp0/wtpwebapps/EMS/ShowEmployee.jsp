<%@page import="com.hcl.ems.EmployeeBaL"%>
<%@page import="com.hcl.ems.Employee"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
		int emp_id = 2000;
		Employee obj = EmployeeBaL.showEmployeeBal(emp_id);
%>
Employ ID :
<%=obj.getEmp_id() %><br/><br/>
Full Name :
<%=obj.getEmp_name() %><br/><br/>
Email Address :
<%=obj.getEmp_email() %><br/><br/>
Mobile Number :
<%=obj.getEmp_mob_no() %><br/><br/>
Date Joined :
<%=obj.getEmp_date_joined() %><br/><br/>
Department :
<%=obj.getEmp_dpt_name() %><br/><br/>
Available leave Balance :
<%=obj.getEmp_leave_balance() %><br/><br/>

<%
int emp_id1 = obj.getEmp_mgr_id();
Employee obj1 = EmployeeBaL.showEmployeeBal(emp_id1);
if (obj1.getEmp_name()==null) {
%>	<%="No manager" %>
<%
} else {
%> 
Manager Id :
<%=obj1.getEmp_id() %><br/><br/>
Full Name :
<%=obj1.getEmp_name() %><br/><br/>
Email Address :
<%=obj1.getEmp_email() %><br/><br/>
Mobile Number :
<%=obj1.getEmp_mob_no() %><br/><br/>
<%
}
%>
</body>
</html>
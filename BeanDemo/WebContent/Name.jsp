<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="bean1" class="com.hcl.beans.Name"></jsp:useBean>
<jsp:setProperty property="fname" name="bean1"/>
<jsp:setProperty property="lname" name="bean1"/>
<jsp:getProperty property="fname" name="bean1"/></br>
<jsp:getProperty property="lname" name="bean1"/>
<%=bean1.Fullname() %>
</body>
</html>
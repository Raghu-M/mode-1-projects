<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<sql:setDataSource
		driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/sqlpractice"
		user="root"
		password="root"
	/>
	
	<sql:query var="bankquery" dataSource="${conn }">
	select max(AccountNo) accno from Accounts 
	</sql:query>
	<c:forEach var="e" items="${bankquery.rows }" >
		<c:set var="accno" value="${e.accno }" />
	</c:forEach>
	<sql:update>
		insert into Accounts values(?,?,?,?,?,?,?)
		<sql:param value="${accno }"></sql:param>
		<sql:param value="${param.fname }"></sql:param>
		<sql:param value="${param.lname }"></sql:param>
		<sql:param value="${param.city }"></sql:param>
		<sql:param value="${param.state }"></sql:param>
		<sql:param value="${param.state }"></sql:param>
		<sql:param value="${param.state }"></sql:param>
	</sql:update>
	<c:out value="Employ Inserted....." />
</body>
</html>
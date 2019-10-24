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
	<sql:setDataSource var="conn"
		driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/bank"
		user="root"
		password="root"
	/>
	<sql:query var="bankquery" dataSource="${conn }">
	select max(AccountNo) accno from Accounts 
	</sql:query>
	<c:forEach var="e" items="${bankquery.rows }" >
		<c:set var="accno" value="${e.accno }" />
	</c:forEach>
	<sql:update var="Accounts" dataSource="${conn }">
		insert into Accounts ( AccountNo,FirstName,LastName,City,State,Amount,CheqFacil,AccountType)values(?,?,?,?,?,?,?,?)
		<sql:param value="${accno+1 }"></sql:param>
		<sql:param value="${param.fname }"></sql:param>
		<sql:param value="${param.lname }"></sql:param>
		<sql:param value="${param.city }"></sql:param>
		<sql:param value="${param.state }"></sql:param>
		<sql:param value="${param.amount }"></sql:param>
		<sql:param value="${param.cqefacil }"></sql:param>
		<sql:param value="${param.acctype }"></sql:param>
	</sql:update>
	<c:out value="Account Created"></c:out>
</body>
</html>
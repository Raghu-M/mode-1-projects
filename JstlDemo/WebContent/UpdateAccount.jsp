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
		var="conn"
		driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/bank"
		user="root"
		password="root"
	/>
	
	<c:set var="flag" value="0" />
	<c:forEach step="1" begin="1" end="1">
		<sql:update var="bankquery" dataSource="${conn }">
		update Accounts set city=?,state=? where Accountno=?
		<sql:param value= "${param.city }" />
		<sql:param value="${param.state }" />
		<sql:param value="${param.accno }" />
		<c:set var="flag" value="1" />
		</sql:update>
		
		<c:if test="${flag==1 }" >
	<c:out value="Account Updated"></c:out>
	</c:if>
	</c:forEach>
	<c:if test="${flag==0 }" >
	<c:out value="Account Not Found"></c:out>
	</c:if>
</body>
</html>
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
	
	<sql:query var="bankquery" dataSource="${conn }">
	select * from Accounts where AccountNo =?
	<sql:param value="${param.accno }"></sql:param>
	</sql:query>
	<c:set var="flag" value="0" />
	<c:forEach var="e" items="${bankquery.rows }" >
	Account No :
	<c:out value="${e.AccountNo }" /> </br>
	First Name :
	<c:out value="${e.FirstName }" /> </br>
	Last Name :
	<c:out value="${e.LastName }" /> </br>
	City :
	<c:out value="${e.City }" /> </br>
	State :
	<c:out value="${e.State }" /> </br>
	Amount :
	<c:out value="${e.Amount }" /> </br>
	Status :
	<c:out value="${e.Status }" /> </br>
	Cheque Facility :
	<c:out value="${e.CheqFacil }" /> </br>
	Account type :
	<c:out value="${e.AccountType }" /> </br>
	Date of Open :
	<c:out value="${e.DateOfOpen }" /> </br>
	
	<c:out value="---------------------------------------------------------" /> </br>
	<c:set var="flag" value="1" />
	</c:forEach>
	<c:if test="${flag==0 }">
		<c:out value="Account Not Found.." />.
	</c:if>
</body>
</html>
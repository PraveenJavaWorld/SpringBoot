<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<title>List</title>
	</head>
	<body>
		<c:choose>
			<c:when test="${!empty list}">
				<table>
					<tr>
						<th>AccountNumber</th>
						<th>DebitCardNumber</th>
						<th>MobileNumber</th>
						<th>CustomerID</th>
					</tr>
					<c:forEach var="cust" items="${list}">
						<tr>
							<td>${cust.accno}</td>
							<td>${cust.cardno}</td>
							<td>${cust.mobile}</td>
							<td>${cust.cid}</td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<h2 style="color: red;text-align: center">No Records Found</h2>
			</c:otherwise>
		</c:choose>
		<h2 style="color: green;text-align: center"><a href="welcome">Home</a></h2>
	</body>
</html>

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
						<th>ID</th>
						<th>Name</th>
						<th>Branch</th>
						<th>UserName</th>
						<th>Password</th>
						<th>Role</th>
						<th>Status</th>
					</tr>
					<c:forEach var="stud" items="${list}">
						<tr>
							<td>${stud.id}</td>
							<td>${stud.name}</td>
							<td>${stud.branch}</td>
							<td>${stud.username}</td>
							<td>${stud.password}</td>
							<td>${stud.role}</td>
							<td>${stud.status}</td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<h2 style="color: red;text-align: center">No Records Found</h2>
			</c:otherwise>
		</c:choose>
		<h2 style="color: green;text-align: center">Result is :: ${msg}</h2>
	</body>
</html>

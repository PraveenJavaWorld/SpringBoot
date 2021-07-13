<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
	<title>Welcome</title>
</head>
<body>
	<form:form action="save" method="POST" modelAttribute="stud">
		<table>
			<tr>
				<td><label>Name</label></td>
				<td><form:input path="name"/></td>
			</tr>
			<tr>
				<td><label>Branch</label></td>
				<td><form:input path="branch"/></td>
			</tr>
			<tr>
				<td><label>UserName</label></td>
				<td><form:input path="username"/></td>
			</tr>
			<tr>
				<td><label>Password</label></td>
				<td><form:password path="password"/></td>
			</tr>
			<tr>
				<td><label>Select Role</label></td>
				<td><form:radiobuttons items="${rolesList}" path="role"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>


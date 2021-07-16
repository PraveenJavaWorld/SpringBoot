<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Email</title>
</head>
<body>
	<form:form action="send" method="POST" modelAttribute="model" enctype="multipart/form-data">
		<table align="center" border="1">
			<tr>
				<td>To</td>
				<td><form:input path="to"/></td>
			</tr>
			<tr>
				<td>From</td>
				<td><form:input path="from"/></td>
			</tr>
			<tr>
				<td>Subject</td>
				<td><form:input path="subject"/></td>
			</tr>
			<tr>
				<td>Body</td>
				<td><form:textarea path="body"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Send"></td>
			</tr>
		</table>
	</form:form>
	<br>
	<h2 style="color: red;text-align: center;">${msg}</h2>
</body>
</html>
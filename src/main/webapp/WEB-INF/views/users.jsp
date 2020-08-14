<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
</head>
<body>
	<h2>Users file</h2>
	<table>
		<thead>
			<th>Username</th>
			<th>Role</th>
			<th>Edit</th>
			<th>Delete</th>
		</thead>
		<tbody>
			<c:forEach var="user" items="${listUsers}">
				<tr>
					<td>${user.username}</td>
					<td>${user.role}</td>
					<td><a href="user/edit/${user.id}">Edit</a></td>
					<td><a href="user/remove/${user.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Capstone 6 | Tasks</title>
</head>
<body>

<h1>Tasks List</h1>

<h2>Welcome ${ user.getEmail() }</h2>

<table>
		<thead>
			<tr>
				<th>Description</th>
				<th>Due</th>
				<th>Complete</th>
				<th>Completed?</th>
				<th>Remove</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="task" items="${ user.tasks }">
				<tr>
					<td>${ task.description }</td>
					<td>${ task.dueDate}</td>
					<td>${ task.complete }</td>
					<td><a href="/completed?id=${task.id}">Completed</a></td>
					<td><a href="/remove?id=${task.id}">Remove</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


<h2>Add a Task</h2>
	<form method="post" action="/addtask">
		Description: <input type="text" name="description" /><br />
		Due Date: <input type="date" name="dueDate" /><br />
		<input type="submit" />
	</form>
 <a href="/logout">Logout</a>
</body>
</html>
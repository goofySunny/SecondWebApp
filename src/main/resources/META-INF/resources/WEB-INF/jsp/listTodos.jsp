<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html>
	<head>
		<title>Login Page</title>
		<link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet"/>
		<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet"/>	
	</head>
	<body>
<%@ include file="common/navbar.jspf" %>
	<div class="container mt-3">
			<h1>Your todos are:</h1>
			<table class="table">
				<thead>
					<tr>
						<th>Description</th>
						<th>TargetDate</th>
						<th>Done?</th>
						<th>Delete</th>
						<th>Update</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ todos }" var="todo">
						<tr>
							<td> ${ todo.description }</td>
							<td> ${ todo.targetDate }</td>
							<td> ${ todo.done }</td>
							<td><a class="btn btn-warning" href="delete-todo?id=${ todo.id }">Delete</a></td>
							<td><a class="btn btn-info" href="update-todo?id=${ todo.id }">Update</a></td>
						</tr>
					</c:forEach>
				</tbody>		
			</table>
			<a href="add-todo" class="btn btn-success">Add todo</a>
		</div>
		<%@ include file="common/footer.jspf" %>
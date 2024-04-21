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
		<div class="container">
			<div>
				<h1>welcome to Meower Tech</h1>
				<p>your Username is ${ name }</p>
				<div><a href="/list-todos">Manage</a> your todos here</div>
			</div>
		</div>
		<%@ include file="common/footer.jspf" %>
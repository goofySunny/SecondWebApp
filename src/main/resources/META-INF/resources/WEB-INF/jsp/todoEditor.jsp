<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html>
	<head>
		<title>Login Page</title>
		<link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet"/>
		<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet"/>	
	</head>
	<body>

<div class="container">
	<h1>Enter Todo Details</h1>
	<form:form method="post" modelAttribute="todo">

		<fieldset class="mb-3">
			<form:label path="description">Description</form:label>
			<form:input type="text" path="description" />
			<form:errors path="description" cssClass="text-danger" />
		</fieldset>

		<fieldset class="mb-3">
			<form:label path="targetDate">Target date</form:label>
			<form:input type="text" path="targetDate" />
			<form:errors path="targetDate" cssClass="text-danger" />
		</fieldset>
				Is it done?<form:checkbox path="done" />

		<form:input type="hidden" path="id" />
		<input type="submit" class="btn btn-success" />
		<div></div>
	</form:form>
</div>
<%@ include file="common/footer.jspf"%>
<script
	src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript">
$('#targetDate').datepicker({
    format: 'yyyy-mm-dd',
    startDate: '-3d'
});
</script>
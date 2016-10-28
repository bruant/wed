<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!doctype html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>The Wedding Organizer</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/wedding.server.css">
</head>
  <body data-ng-app="formSubmit">

	<script type="text/javascript">
		var ctx = '<%= request.getContextPath()%>';
	</script>

    <script src="${pageContext.request.contextPath}/js/lib/jquery-v1.11.1.js"></script>
    <script src="${pageContext.request.contextPath}/js/lib/angular.min.1.3.8.js"></script>
    <script src="${pageContext.request.contextPath}/js/lib/angular-route.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/lib/angular-resource.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/app/wedding.registration.js"></script>

	<h2>Registration</h2>
	<h3>Please give your details</h3>

    <div>

		<form data-ng-submit="submit()" data-ng-controller="FormSubmitController">
				<h3>{{headerText}}</h3>
				<p>Guest code: <input type="text" data-ng-model="guestCode"></p>
				<p>Email: <input type="text" data-ng-model="email"></p>
				<p>Name: <input type="text" data-ng-model="name"></p>
				<p>Password: <input type="password" data-ng-model="password"></p>
				<p>Confirm Password: <input type="password" data-ng-model="passwordToConfirm"></p>
				<input type="submit" id="submit" value="Submit" /><br>

				<h4>You submitted below data through post:</h4>
				 <pre>Form data ={{list}}</pre>
		</form>
		</div>

  </body>
</html>
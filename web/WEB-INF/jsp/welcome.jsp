<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title><spring:message code="welcome.title" text="default text" /></title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/wedding.server.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/animate.css">
</head>
  <body data-ng-app="formSubmit">

	<script type="text/javascript">
		var ctx = '<%= request.getContextPath()%>';
	</script>

    <script src="${pageContext.request.contextPath}/js/lib/jquery-1.12.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/lib/angular.min.1.3.8.js"></script>
    <script src="${pageContext.request.contextPath}/js/lib/angular-route.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/lib/angular-resource.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/app/wedding.login.js"></script>

	<script type="text/javascript">

	$(document).ready(function(){
	    $('#login2').each(function() {
	    	animationClick(this, 'fadeOut');
	    });
	});

	</script>

	<h2>Welcome to the wedding organizer</h2>

    <div style="width: 30%; background-color: white;" id="boxshadow">
		<form data-ng-submit="submit()" data-ng-controller="FormSubmitController">
				<h3>{{headerText}}</h3>
				<p>Email:    <input type="text" data-ng-model="email"></p>
				<p>Password: <input type="password" data-ng-model="password"></p>
				<input id="login" type="image" value="Submit" src="${pageContext.request.contextPath}/img/login.png" width="12%" height="12%" ng-class="style"/><br>
				 <pre>Form data ={{list}}</pre>
		</form>

        <div>
        <a href="/server/registration/init">Sign up</a>
        </div>
    </div>
  </body>
</html>
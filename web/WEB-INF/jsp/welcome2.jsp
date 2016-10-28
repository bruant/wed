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
  <body>

	<script type="text/javascript">
		var ctx = '<%= request.getContextPath()%>';
	</script>

    <script src="${pageContext.request.contextPath}/js/lib/jquery-1.11.1.js"></script>
    <script src="${pageContext.request.contextPath}/js/lib/angular.min.1.3.8.js"></script>
    <script src="${pageContext.request.contextPath}/js/lib/angular-route.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/lib/angular-resource.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/app/wedding.login.js"></script>

	<script type="text/javascript">

		function animationClick(element, animation){
		    element = $(element);
		    element.click(
		        function() {
		            element.addClass('animated ' + animation);
		            //wait for animation to finish before removing classes
		            window.setTimeout( function(){
		                element.removeClass('animated ' + animation);
		            }, 2000);

		        });
		}

		$(document).ready(function(){
		    $('#login').each(function() {
		    	animationClick(this, 'bounce');
		    });
		});
	</script>


	<h2>Welcome to the wedding organizer</h2>
	<h3>Please login or sign up ...</h3>

    <div>
		<form data-ng-submit="submit()" data-ng-controller="FormSubmitController">
				<h3>{{headerText}}</h3>
				<p>Email: <input type="text" data-ng-model="email"></p>
				<p>Password: <input type="password" data-ng-model="password"></p>
				<input id="login" type="submit" value="Submit" src="${pageContext.request.contextPath}/button/login.png" class="animated bounce"/><br>
				 <pre>Form data ={{list}}</pre>
		</form>

        <div>
        <a href="/server/registration/init">Sign up</a>
        </div>
    </div>
  </body>
</html>
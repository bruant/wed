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
    <link rel="stylesheet" href="css/wedding.server.css">
</head>
  <body>

	<h2>Welcome to the wedding organizer</h2>
	<h3>Please login or sign up ...</h3>

    <div>
		<h3>Registration</h3>
		<form:form method="POST" action="/server/login" modelAttribute="login">
		   <table>
		    <tr>
		        <td><form:label path="email">E-mail</form:label></td>
		        <td><form:input path="email" /></td>
		    </tr>
		    <tr>
		        <td><form:label path="password">Password</form:label></td>
		        <td><form:password path="password" /></td>
		    </tr>
		    <tr>
		        <td colspan="2">
		            <input type="submit" value="Submit"/>
		        </td>
		    </tr>
		</table>
		</form:form>
        <div>
        <a href="/server/registration">Sign up</a>
        </div>
    </div>
  </body>
</html>
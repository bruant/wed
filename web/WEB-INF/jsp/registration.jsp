<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>The Wedding Organizer</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/wedding.server.css">
</head>
  <body>

	<h2>Welcome to the wedding organizer</h2>
	<h3>Please login or sign up ...</h3>

    <div>
	<h3>Registration</h3>
        User:
        <input type="text"/>
        Password:
        <input type="password"/>
        <div>
        <a href="/server/login">Login</a>
        </div>
        <div>
        <a href="/server/registration">Sign up</a>
        </div>
    </div>


    <!-- div ng-controller="TestCtrl">
        <h1>{{title}}</h1>
        <input type="text" ng-model="title">
    </div  -->
    <script src="js/lib/jquery-v1.11.1.js"></script>
    <script src="js/lib/angular.min.js"></script>
    <script src="js/lib/angular-route.min.js"></script>
    <script src="js/lib/angular-resource.min.js"></script>
    <script src="js/app/wedding.server.js"></script>

  </body>
</html>
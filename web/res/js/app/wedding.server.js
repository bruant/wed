function TestCtrl($scope) {
	$scope.title = 'Write a title here...';
};


var app = angular.module('app', ['ngRoute','ngResource']);
app.config(function($routeProvider){
    $routeProvider
        .when('/gallery',{
            templateUrl: 'resources/static/views/gallery.html',
            controller: 'galleryController'
        })
        .when('/reg',{
            templateUrl: '/registration?username=' + username,
            controller: 'registrationController'
        })
        .otherwise(
            { redirectTo: '/'}
        );
});



app.controller('registrationController', function($scope) {
	});
app.controller('contactusController', function($scope) {
    $scope.headingTitle = "Contact Info";
});



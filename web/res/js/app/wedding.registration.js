var app = angular.module('formSubmit', []);

app.controller('FormSubmitController',[ '$scope', '$http', function($scope, $http) {

$scope.list = [];
	$scope.headerText = 'AngularJS Post Form Spring MVC example: Submit below form';
	$scope.submit = function() {

		var formData = {
				"guestCode" : $scope.guestCode,
				"email" : $scope.email,
				"passwordToConfirm" : $scope.passwordToConfirm,
				"password" : $scope.password,
				"name" : $scope.name
		};

		var response = $http.post(ctx + '/registration', formData);
		response.success(function(data, status, headers, config) {
			$scope.list.push(data);
		});
		response.error(function(data, status, headers, config) {
			alert( "Exception details: " + JSON.stringify({data: data}));
		});

		//Empty list data after process
		$scope.list = [];

	};
}]);


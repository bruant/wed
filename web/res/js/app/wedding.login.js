var app = angular.module('formSubmit', []);

app.controller('FormSubmitController',[ '$scope', '$http', function($scope, $http) {

	$scope.headerText = 'Please login or sign up ...';
	$scope.submit = function() {

		var formData = {
				"email" : $scope.email,
				"password" : $scope.password
		};

		 setTimeout(function ()
				   {
				     $scope.$apply(function()
				     {
				 		$scope.style='animated fadeOut';
				 		$scope.list = [];
				     });
				   }, 500);

		 var response = $http.post(ctx + '/login', formData);
		response.success(function(data, status, headers, config) {

			 setTimeout(function ()
					   {
					     $scope.$apply(function()
					     {
								$scope.list.push(data);
								$scope.style='animated fadeIn';
					     });
					   }, 1000);

		});
		response.error(function(data, status, headers, config) {
			alert( "Exception details: " + JSON.stringify({data: data}));
		});

		//Empty list data after process
		$scope.list = [];

	};
}]);

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


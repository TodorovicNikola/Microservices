
(function (angular) {
	var usersModule = angular.module('app.usersCtrl', []);

	var usersController = [ '$scope', '$http',function ($scope, $http){


		$scope.getData=function(){

			$http({
				method: 'GET',
				url: '/user-service/users'
			}).success(function(response){
				$scope.data=response;
				console.log(response);
			})
			.error(function(error){
				console.log(error);
			});

		}
		$scope.getData();

	}];
	usersModule.controller('usersCtrl', usersController);
}(angular));

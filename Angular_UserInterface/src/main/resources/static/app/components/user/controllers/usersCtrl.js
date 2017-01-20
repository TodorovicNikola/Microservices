
(function (angular) {
	var usersModule = angular.module('app.usersCtrl', []);

	var usersController = [ '$scope', '$http','$location',function ($scope, $http,$location){


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

		$scope.saveUser=function()
		{
			console.log($scope.user.role);

			$http({
				method: 'POST',
				url: '/user-service/registerUser',
				data:$scope.user
			}).success(function(response){
				$scope.data=response;

				console.log(response);

				window.location="#/users";
			})
			.error(function(error){
				alert("Error when registering a user : " + error);
				console.log(error);
			});

		}
		$scope.validateUserForm=function()
		{

			if($scope.user==null)
			{
				return false;
			}
			if (!$scope.user.firstName || !$scope.user.lastName  || !$scope.user.mail || !$scope.user.password ||  !$scope.user.role)
			{
				return false;
			}
			return true;
		}


		$scope.userRoles=['regular','moderator'];
		$scope.getData();

	}];
	usersModule.controller('usersCtrl', usersController);
}(angular));

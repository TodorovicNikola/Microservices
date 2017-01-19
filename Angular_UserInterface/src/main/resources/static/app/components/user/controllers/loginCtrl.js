
(function (angular) {
	var loginModule = angular.module('app.loginCtrl', ['app.loginService']);

	var loginController = [ '$scope', '$http','loginService','$location',function ($scope, $http,loginService,$location){


		$scope.user={
				email: "",
				password: ""
		};
		$scope.login=function () {

			console.log('login');
			loginService.login($scope.user.email,$scope.user.password,loginCbck);
		};
		function loginCbck(success) {
			if (success) {
				console.log("success");
				
				window.location = "#/users";
			}
			else{
				alert('failure!');
				window.location = "#/login";
			}
		}
	}];
	loginModule.controller('loginCtrl', loginController);
}(angular));

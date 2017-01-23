
(function (angular) {
	var loginModule = angular.module('app.loginCtrl', ['app.loginService']);

	var loginController = [ '$scope', '$http','loginService','$location',function ($scope, $http,loginService,$location){

		if (loginService.getCurrentUser()!=null)
			window.location = "#documents";
		
		$scope.user={
				email: "",
				password: ""
		};
		$scope.login=function () {

			loginService.login($scope.user.email,$scope.user.password,loginCbck);
		};
		function loginCbck(success) {
			if (success) {
				console.log(loginService.getCurrentUser());
				window.location = "#/createPregledProv";
			}
			else{
				alert('failure!');
				window.location = "#/login";
			}
		}
	}];
	loginModule.controller('loginCtrl', loginController);
}(angular));

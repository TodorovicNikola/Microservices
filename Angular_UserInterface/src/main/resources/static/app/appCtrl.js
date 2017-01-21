(function (angular) {
	var appModule = angular.module('appModule', ['app.loginService']);

	var appController = ['$http','$scope','loginService','$location','$localStorage', function($http,$scope,loginService,$location,$localStorage) {

		
		$scope.currentUser = $localStorage.currentUser;
		console.log("here " + $scope.currentUser);
		$scope.logout=function()
		{
			loginService.logout();
			window.location="#/login";
		}
		$scope.getCurrentUser=function()
		{
			console.log($localStorage.currentUser);
			return $localStorage.currentUser;
		}

		


	}];
	appModule.controller('appController', appController);
}(angular));
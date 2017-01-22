(function (angular) {
	var appModule = angular.module('appModule', ['app.loginService']);

	var appController = ['$http','$scope','loginService','$location','$localStorage', function($http,$scope,loginService,$location,$localStorage) {

		
		$scope.currentUser = $localStorage.currentUser;
		$scope.logout=function()
		{
			loginService.logout();
			window.location="#/login";
		}
		$scope.getCurrentUser=function()
		{
			return $localStorage.currentUser;
		}

	}];
	appModule.controller('appController', appController);
}(angular));
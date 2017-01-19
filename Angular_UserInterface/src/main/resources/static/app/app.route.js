(function(){
	'use strict';

	angular
	.module('SMPuOS')
	.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){
		$urlRouterProvider.otherwise("/login");

		$stateProvider
		.state('home', {
			url: '/home',
			templateUrl: 'app/components/home/home.html',
			controller: 'homeController',
			controllerAs: 'hc'

		}).state('login', {
			url: '/login',
			templateUrl: 'app/components/user/views/login.html',
			controller: 'loginCtrl',
			controllerAs: 'lc'

		}).state('users', {
			url: '/users',
			templateUrl: 'app/components/user/views/users.html',
			controller: 'usersCtrl',
			controllerAs: 'uc'
		})
	}]);

	})();

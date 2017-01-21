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
		}).state('registerUser', {
			url: '/registerUser',
			templateUrl: 'app/components/user/views/registerUser.html',
			controller: 'usersCtrl',
			controllerAs: 'uc'
		}).state('documents', {
			url: '/documents',
			templateUrl: 'app/components/document/views/documents.html',
			controller: 'documentsCtrl',
			controllerAs: 'dc'
		}).state('documentId', {
			url: '/documents/:id',
			templateUrl:  'app/components/document/views/documentView.html',
			controller: 'documentDetailCtrl',
			controllerAs: 'dc'
	    })
	    .state('createDocument', {
			url: '/createDocument',
			templateUrl:  'app/components/document/views/documentView.html',
			controller: 'documentDetailCtrl',
			controllerAs: 'ddc'
	    })
		
	}]);

	})();

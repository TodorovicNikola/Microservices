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
		}).state('createPregledProvCtrl', {
			url: '/createPregledProv',
			templateUrl: 'app/components/pregledProveravaca/views/createPregledProv.html',
			controller: 'createPregledProvCtrl',
			controllerAs: 'cppc'
				
		}).state('viewPregledProvCtrl', {
			url: '/viewPregledProv',
			templateUrl: 'app/components/pregledProveravaca/views/viewPregledProv.html',
			controller: 'viewPregledProvCtrl',
			controllerAs: 'vppc'
				
		}).state('crProgIPlIntProvCtrl', {
			url: '/crProgIPlIntProv',
			templateUrl: 'app/components/progrIPlanIntProv/views/createProgrIPlanIntProv.html',
			controller: 'crProgIPlIntProvCtrl',
			controllerAs: 'cpipip'		
		
		}).state('allProgIPlanIntProvCtrl', {
			url: '/allProgIPlanIntProv',
			templateUrl: 'app/components/progrIPlanIntProv/views/allProgrIPlanIntProv.html',
			controller: 'allProgIPlanIntProvCtrl',
			controllerAs: 'apipip'		
					
		}).state('progIPlanIntProvCtrl', {
			url: '/progIPlanIntProv',
			templateUrl: 'app/components/progrIPlanIntProv/views/ProgrIPlanIntProv.html',
			controller: 'progIPlanIntProvCtrl',
			params: {
                id: null
            },
			controllerAs: 'pipip'		
			
				
		}).state('updProgIPlanIntProvCtrl', {
			url: '/updProgIPlanIntProv',
			templateUrl: 'app/components/progrIPlanIntProv/views/updProgrIPlanIntProv.html',
			controller: 'updProgIPlanIntProvCtrl',
			params: {
                id: null
            },
			controllerAs: 'upipip'		
				
		}).state('createObavOIntProv', {
			url: '/createObavOIntProv',
			templateUrl: 'app/components/obavOIntProv/views/createObavOIntProv.html',
			controller: 'createObavOIntProvCtrl',
			controllerAs: 'coip'
		}).state('updObavOIntProv', {
			url: '/updObavOIntProv',
			templateUrl: 'app/components/obavOIntProv/views/updObavOIntProv.html',
			controller: 'updObavOIntProvCtrl',
			params: {
                id: null
            },
			controllerAs: 'uoip'
				
		}).state('obavOIntProv', {
			url: '/obavOIntProv',
			templateUrl: 'app/components/obavOIntProv/views/obavOIntProv.html',
			controller: 'obavOIntProvCtrl',
			params: {
                id: null
            },
			controllerAs: 'oip'
				
		}).state('allObavOIntProv', {
			url: '/allObavOIntProv',
			templateUrl: 'app/components/obavOIntProv/views/allObavOIntProv.html',
			controller: 'allObavOIntProvCtrl',
			controllerAs: 'aoip'
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
	    }).state('createDocument', {
			url: '/createDocument',
			templateUrl:  'app/components/document/views/documentView.html',
			controller: 'documentDetailCtrl',
			controllerAs: 'ddc'
	    }).state('createQualityDocument', {
			url: '/createQualityDocument',
			templateUrl:  'app/components/documentKvalitet/views/documentView.html',
			controller: 'documentQualityDetailCtrl',
			controllerAs: 'dqdc'
	    }).state('qualityDocuments', {
			url: '/qualityDocuments',
			templateUrl:  'app/components/documentKvalitet/views/documents.html',
			controller: 'documentsQualityCtrl',
			controllerAs: 'qc'
	    }).state('qualityDocumentId', {
			url: '/qualityDocuments/:id',
			templateUrl:  'app/components/documentKvalitet/views/documentView.html',
			controller: 'documentQualityDetailCtrl',
			controllerAs: 'dqdc'
		});
}]);

	})();	


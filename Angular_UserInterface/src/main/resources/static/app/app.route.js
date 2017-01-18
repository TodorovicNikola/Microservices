(function(){
	'use strict';
	 
	angular
		.module('SMPuOS')
		.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){
			
			$urlRouterProvider.otherwise("/home");
			
			$stateProvider
				.state('home', {
					url: '/home',
					templateUrl: 'app/components/home/home.html',
					controller: 'homeController',
					controllerAs: 'hc'
					
				});
			
		}]);

})();

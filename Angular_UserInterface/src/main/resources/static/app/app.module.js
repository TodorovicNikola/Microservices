(function () {
	'use strict';
	
	angular
		.module('SMPuOS', ['ui.router','app.loginCtrl','app.loginService','ngStorage','appModule','app.usersCtrl','app.documentsCtrl','app.documentDetailCtrl']).run(function($http,$localStorage)
				{
			$http.defaults.headers.common.Authorization = $localStorage.token;
				});
	

})();

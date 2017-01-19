
var loginService= angular.module('app.loginService', ['ngStorage']);
loginService.factory('loginService', ['$http','$localStorage',function($http,$localStorage) {

	var service = {};

	function login(email, password, callback) {

		$http({
			method: 'GET',
			url: '/user-service/login?mail='+ email+ "&password="+password,
			
		}).success(function(response)
				{
			if (response) {
				console.log("response" + response);
				var currentUser = { email: email, token: response }
				
				$localStorage.currentUser = currentUser;
				$localStorage.token='Bearer '+response['token'];
				$http.defaults.headers.common.Authorization = $localStorage.token;
				console.log(response);
				// callback za uspesan login
				callback(true);
			} else {

				callback(false);
			}
				}

		)
		.error(function(response)
				{
			callback(false);
				})


	}


	function logout() {
		// uklonimo korisnika iz lokalnog skladišta
		delete $localStorage.currentUser;
		delete $localStorage.token;
		$http.defaults.headers.common.Authorization = '';
		delete $http.defaults.headers.common["Authorization"];
	}

	function getCurrentUser() {
		return $localStorage.currentUser;
	}

	service.login = login;
	service.logout = logout;
	service.getCurrentUser = getCurrentUser;

	return service;
}]);





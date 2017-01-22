
var loginService= angular.module('app.loginService', ['ngStorage','angular-jwt']);
loginService.factory('loginService', ['jwtHelper','$http','$localStorage',function(jwtHelper,$http,$localStorage) {

	var service = {};

	function login(email, password, callback) {

		$http({
			method: 'GET',
			url: '/user-service/login?mail='+ email+ "&password="+password,

		}).success(function(response)
				{
			if (response) {
				console.log(response);			
				var tokenPayload = jwtHelper.decodeToken(response['token']);
				if(tokenPayload.role){
					var currentUser={};
					currentUser.role = tokenPayload.role;
					currentUser.firstName=tokenPayload.firstName;
					currentUser.lastName=tokenPayload.lastName;
					currentUser.id=tokenPayload.id;
					console.log(currentUser);
					$localStorage.currentUser = currentUser;
					//$localStorage.token='Bearer '+response['token'];
					$localStorage.token=response['token'];
					$http.defaults.headers.common.Authorization = $localStorage.token;
				}	
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





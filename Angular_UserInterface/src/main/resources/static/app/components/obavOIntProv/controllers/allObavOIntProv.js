(function(){
	'use strict';
	
	angular
		.module("SMPuOS")
		.controller('allObavOIntProvCtrl', allObavOIntProvCtrl);
	
	allObavOIntProvCtrl.$inject = ['$http', '$stateParams'];
	function allObavOIntProvCtrl($http, $stateParams){
		var aoip=this;
		
		aoip.obavOIntProv = {};
		aoip.obavOIntProv.timZaProveru = [];
		aoip.obavOIntProv.komentari = [];
		aoip.obavOIntProv.verifikovan = false;
		
		
		
		$http({
			method: 'GET',
			url: '/notification/all',
		}).success(function(response){

			aoip.obavOIntProv = response;

		})
		.error(function(error){
			alert("Error");
			console.log(error);
		});
			
	}
	

})();
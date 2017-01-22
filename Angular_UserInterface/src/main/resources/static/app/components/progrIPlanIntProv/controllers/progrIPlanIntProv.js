(function(){
	'use strict';
	
	angular
		.module("SMPuOS")
		.controller('progIPlanIntProvCtrl', progIPlanIntProvCtrl);
	
	progIPlanIntProvCtrl.$inject = ['$http', '$stateParams'];
	function progIPlanIntProvCtrl($http, $stateParams){
		var pipip=this;
		
		pipip.progrIPlanIntProv = {};
		pipip.progrIPlanIntProv.redoviTabele = [];
		
		$http({
			method: 'GET',
			url: '/check-programme/get?id=' + $stateParams.id,
		}).success(function(response){

			pipip.progrIPlanIntProv = response;

		})
		.error(function(error){
			alert("Error");
			console.log(error);
		});
			
	}
	

})();
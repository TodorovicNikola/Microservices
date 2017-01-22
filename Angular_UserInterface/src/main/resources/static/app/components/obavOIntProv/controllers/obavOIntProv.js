(function(){
	'use strict';
	
	angular
		.module("SMPuOS")
		.controller('obavOIntProvCtrl', obavOIntProvCtrl);
	
	obavOIntProvCtrl.$inject = ['$http', '$stateParams'];
	function obavOIntProvCtrl($http, $stateParams){
		var oip=this;
		
		oip.progrIPlanIntProv = {};
		oip.progrIPlanIntProv.redoviTabele = [];
		
		$http({
			method: 'GET',
			url: '/check-programme/get?id=' + $stateParams.id,
		}).success(function(response){

			oip.progrIPlanIntProv = response;

		})
		.error(function(error){
			alert("Error");
			console.log(error);
		});
			
	}
	

})();
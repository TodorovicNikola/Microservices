(function(){
	'use strict';
	
	angular
		.module("SMPuOS")
		.controller('updObavOIntProvCtrl', updObavOIntProvCtrl);
	
	updObavOIntProvCtrl.$inject = ['$http', '$stateParams'];
	function updObavOIntProvCtrl($http, $stateParams){
		var uoip=this;
		
		uoip.progrIPlanIntProv = {};
		uoip.progrIPlanIntProv.redoviTabele = [];
		
		$http({
			method: 'GET',
			url: '/check-programme/get?id=' + $stateParams.id,
		}).success(function(response){

			uoip.progrIPlanIntProv = response;

		})
		.error(function(error){
			alert("Error");
			console.log(error);
		});
			
	}
	

})();
(function(){
	'use strict';
	
	angular
		.module("SMPuOS")
		.controller('obavOIntProvCtrl', obavOIntProvCtrl);
	
	obavOIntProvCtrl.$inject = ['$http', '$stateParams'];
	function obavOIntProvCtrl($http, $stateParams){
		var oip=this;
		
		oip.obavOIntProv = {};
		
		$http({
			method: 'GET',
			url: '/notification/get?id=' + $stateParams.id,
		}).success(function(response){

			oip.obavOIntProv = response;

		})
		.error(function(error){
			alert("Error");
			console.log(error);
		});
		
		oip.verify = function(){
			oip.obavOIntProv.verifikovan = true;
			
			$http({
				headers: { 
			        'Accept': 'application/json',
			        'Content-Type': 'application/json' 
			    },
				method: 'POST',
				url: '/notification/update',
				data:oip.obavOIntProv
			}).success(function(response){
				oip.data=response;

				console.log(response);

				//window.location="#/users";
			})
			.error(function(error){
				alert("Error when registering a user : " + error);
				console.log(error);
			});
		}
			
	}
	

})();
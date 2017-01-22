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
		
		alert($stateParams.id);
		
		$http({
			method: 'GET',
			url: '/notification/get?id=' + $stateParams.id,
		}).success(function(response){
			console.log(response);
			uoip.obavOIntProv = response;

		})
		.error(function(error){
			alert("Error");
			console.log(error);
		});
		
		uoip.sacuvaj = function(){
			$http({
				headers: { 
			        'Accept': 'application/json',
			        'Content-Type': 'application/json' 
			    },
				method: 'POST',
				url: '/notification/update',
				data:uoip.obavOIntProv
			}).success(function(response){
				uoip.data=response;

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
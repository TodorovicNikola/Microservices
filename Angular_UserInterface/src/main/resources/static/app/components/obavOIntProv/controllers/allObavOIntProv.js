(function(){
	'use strict';
	
	angular
		.module("SMPuOS")
		.controller('allObavOIntProvCtrl', allObavOIntProvCtrl);
	
	allObavOIntProvCtrl.$inject = ['$http', '$state'];
	function allObavOIntProvCtrl($http, $state){
		var aoip=this;
		
		aoip.obavOIntProv = []; 
		
		$http({
			method: 'GET',
			url: '/notification/all',
		}).success(function(response){

			aoip.obavestenja = response;

		})
		.error(function(error){
			alert("Error");
			console.log(error);
		});
		
		aoip.odaberi = function(id){
			$state.go('obavOIntProv', { id: id });
		}
		
		aoip.izmeni = function(id){
			$state.go('updObavOIntProv', { id: id });
		}
			
		
		aoip.obrisi = function(id){
			if(window.confirm("Da li ste sigurni da zelite da obrisete?")){
				$http({
					method: 'GET',
					url: '/notification/delete?id=' + id,
				}).success(function(response){
					console.log(response);

				})
				.error(function(error){
					alert("Error");
					console.log(error);
				});
			}
		}
		
	}
	

})();
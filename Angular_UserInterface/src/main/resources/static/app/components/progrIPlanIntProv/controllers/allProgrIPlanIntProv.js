(function(){
	'use strict';
	
	angular
		.module("SMPuOS")
		.controller('allProgIPlanIntProvCtrl', allProgIPlanIntProvCtrl);
	
	allProgIPlanIntProvCtrl.$inject = ['$http', '$state'];
	function allProgIPlanIntProvCtrl($http, $state){
		var apipip=this;
		
		apipip.programi = {};
		
		apipip.obrisi = function(id){
			if(window.confirm("Da li ste sigurni da zelite da obrisete?")){
				$http({
					method: 'GET',
					url: '/check-programme/delete?id=' + id,
				}).success(function(response){
					console.log(response);

				})
				.error(function(error){
					alert("Error");
					console.log(error);
				});
			}
			

			
		}
		
		apipip.odaberi = function(id){
			$state.go('progIPlanIntProvCtrl', { id: id });
		}
		
		apipip.izmeni = function(id){
			$state.go('updProgIPlanIntProvCtrl', { id: id });
		}
		
		
		$http({
			method: 'GET',
			url: '/check-programme/all',
		}).success(function(response){
			apipip.programi=response;

			console.log(response);

		})
		.error(function(error){
			alert("Error");
			console.log(error);
		});

	}

})();
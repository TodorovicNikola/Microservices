(function(){
	'use strict';
	
	angular
		.module("SMPuOS")
		.controller('viewPregledProvCtrl', viewPregledProvCtrl);
	
	viewPregledProvCtrl.$inject = ['$http'];
	function viewPregledProvCtrl($http){
		var vppc=this;

		vppc.auditorOverview = {};
		
		vppc.auditorOverview.id = null;
		vppc.auditorOverview.auditors = [];
		
		$http({
			method: 'GET',
			url: '/auditor-overview/all',
		}).success(function(response){
			vppc.auditorOverview=response;

			console.log(response);

		})
		.error(function(error){
			alert("Error");
			console.log(error);
		});
	}
})();
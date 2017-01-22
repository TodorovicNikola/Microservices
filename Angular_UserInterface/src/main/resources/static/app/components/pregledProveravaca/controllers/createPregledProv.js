(function(){
	'use strict';
	
	angular
		.module("SMPuOS")
		.controller('createPregledProvCtrl', createPregledProvCtrl);
	
	createPregledProvCtrl.$inject = ['$http'];
	function createPregledProvCtrl($http){
		var cppc=this;

		cppc.auditorOverview = {};
		
		cppc.auditorOverview.id = null;
		cppc.auditorOverview.auditors = [];
		
		$http({
			method: 'GET',
			url: '/auditor-overview/all',
		}).success(function(response){
			cppc.auditorOverview=response;

			console.log(response);

		})
		.error(function(error){
			alert("Error");
			console.log(error);
		});
		
		
		
		
		cppc.dodajRed = function () {
		    var table = document.getElementById("pp");
		    var row = table.insertRow(-1);
		    row.innerHTML = "<td> <input required placeholder=\"Ime i prezime\" class=\"form-control\" id=\"inputOznaka\" type=\"text\"></td> <td> <input required placeholder=\"Oblast\" class=\"form-control\" id=\"inputOznaka\" type=\"text\"></td>";
		};
		
		cppc.ukloniRed = function () {
		    var table = document.getElementById("pp");
		    var row = table.deleteRow(-1);
		    
		};
		
		cppc.savePregPred = function(){
			var table = document.getElementById("pp");
			
			cppc.auditorOverview.auditors = [];
			
			for (var i = 1, row; row = table.rows[i]; i++) {
				var temp = {};
				temp.imeIPrezime = row.cells[0].children[0].value;
				temp.oblast = row.cells[1].children[0].value;
				
				if(temp.imeIPrezime == "" || temp.oblast == ""){
					alert("Sva polja moraju biti popunjena!");
					cppc.auditorOverview.auditors = [];
					return false;					
				}
				
				cppc.auditorOverview.auditors.push(temp);
			}
			
			$http({
				headers: { 
			        'Accept': 'application/json',
			        'Content-Type': 'application/json' 
			    },
				method: 'POST',
				url: '/auditor-overview/update',
				data:cppc.auditorOverview
			}).success(function(response){
				cppc.data=response;

				console.log(response);

				//window.location="#/users";
			})
			.error(function(error){
				alert("Error when registering a user : " + error);
				console.log(error);
			});
		};
		

	}
})();
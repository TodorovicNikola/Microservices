(function(){
	'use strict';
	
	angular
		.module("SMPuOS")
		.controller('updProgIPlanIntProvCtrl', updProgIPlanIntProvCtrl);
	
	updProgIPlanIntProvCtrl.$inject = ['$http', '$stateParams'];
	function updProgIPlanIntProvCtrl($http, $stateParams){
		var upipip=this;
		
		upipip.progrIPlanIntProv = {};
		upipip.progrIPlanIntProv.redoviTabele = [];
		
		$http({
			method: 'GET',
			url: '/check-programme/get?id=' + $stateParams.id,
		}).success(function(response){

			upipip.progrIPlanIntProv = response;
			console.log(response);

		})
		.error(function(error){
			alert("Error");
			console.log(error);
		});
			
		
		upipip.dodajRed = function() {
		    var table = document.getElementById("pipip");
		    var row = table.insertRow(-1);
		    row.innerHTML = "<td style=\"width:650px\"> <input class=\"form-control\" id=\"inputOznaka\" type=\"text\"></td> <td style=\"width:450px\"> <input class=\"form-control\" id=\"inputOznaka\" type=\"text\"></td> <td style=\"width:350px\"> <input class=\"form-control\" id=\"inputOznaka\" type=\"text\"></td> <td style=\"width:80px\"> <input class=\"form-control\" id=\"inputOznaka\" type=\"text\"></td> <td style=\"width:80px\"> <input class=\"form-control\" id=\"inputOznaka\" type=\"text\"></td>";
		}
		
		upipip.ukloniRed = function () {
		    var table = document.getElementById("pipip");
		    var row = table.deleteRow(-1);
		    
		};
		
		upipip.savePipip = function(){
			
			if( !upipip.progrIPlanIntProv.datum || !upipip.progrIPlanIntProv.vrstaProvere || !upipip.progrIPlanIntProv.broj || !upipip.progrIPlanIntProv.poNaloguBr || !upipip.progrIPlanIntProv.datumOd || !upipip.progrIPlanIntProv.orgJedinica || !upipip.progrIPlanIntProv.datumProvere || !upipip.progrIPlanIntProv.rokZaDosNalaza){
				alert("Sva polja moraju biti popunjena!");
				
				return false;
			}
			
			var table = document.getElementById("pipip");
			
			upipip.progrIPlanIntProv.redoviTabele = [];
			
			for (var i = 1, row; row = table.rows[i]; i++) {
				var tempTableRow = {};
				tempTableRow.progProv = row.cells[0].children[0].value;
				tempTableRow.potrPris = row.cells[1].children[0].value;
				tempTableRow.prov = row.cells[2].children[0].value;
				tempTableRow.vremeOd = row.cells[3].children[0].value;
				tempTableRow.vremeDo = row.cells[4].children[0].value;
				
				if(tempTableRow.progProv == "" || tempTableRow.potrPris == "" || tempTableRow.prov == "" || tempTableRow.vremeOd == "" || tempTableRow.vremeDo == "" ){
					alert("Sva polja moraju biti popunjena!");
					upipip.progrIPlanIntProv.redoviTabele = [];
					return false;					
				}
								
				upipip.progrIPlanIntProv.redoviTabele.push(tempTableRow);
			}
			
			$http({
				headers: { 
			        'Accept': 'application/json',
			        'Content-Type': 'application/json' 
			    },
				method: 'POST',
				url: '/check-programme/update',
				data:upipip.progrIPlanIntProv
			}).success(function(response){
				upipip.data=response;

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
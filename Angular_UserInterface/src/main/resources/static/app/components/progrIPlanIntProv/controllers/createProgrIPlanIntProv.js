(function(){
	'use strict';
	
	angular
		.module("SMPuOS")
		.controller('crProgIPlIntProvCtrl', crProgIPlIntProvCtrl);
	
	crProgIPlIntProvCtrl.$inject = ['$http'];
	function crProgIPlIntProvCtrl($http){
		var cpipip=this;
		
		cpipip.progrIPlanIntProv = {};
		cpipip.progrIPlanIntProv.redoviTabele = [];
		
		cpipip.progrIPlanIntProv.id = null;
		
		cpipip.dodajRed = function() {
		    var table = document.getElementById("pipip");
		    var row = table.insertRow(-1);
		    row.innerHTML = "<td style=\"width:650px\"> <input class=\"form-control\" id=\"inputOznaka\" type=\"text\"></td> <td style=\"width:450px\"> <input class=\"form-control\" id=\"inputOznaka\" type=\"text\"></td> <td style=\"width:350px\"> <input class=\"form-control\" id=\"inputOznaka\" type=\"text\"></td> <td style=\"width:80px\"> <input class=\"form-control\" id=\"inputOznaka\" type=\"text\"></td> <td style=\"width:80px\"> <input class=\"form-control\" id=\"inputOznaka\" type=\"text\"></td>";
		}
		
		cpipip.savePipip = function(){
			
			if( !cpipip.progrIPlanIntProv.datum || !cpipip.progrIPlanIntProv.vrstaProvere || !cpipip.progrIPlanIntProv.broj || !cpipip.progrIPlanIntProv.poNaloguBr || !cpipip.progrIPlanIntProv.datumOd || !cpipip.progrIPlanIntProv.orgJedinica || !cpipip.progrIPlanIntProv.datumProvere || !cpipip.progrIPlanIntProv.rokZaDosNalaza){
				alert("Sva polja moraju biti popunjena!");
				
				return false;
			}
			
			var table = document.getElementById("pipip");
			
			for (var i = 1, row; row = table.rows[i]; i++) {
				var tempTableRow = {};
				tempTableRow.progProv = row.cells[0].children[0].value;
				tempTableRow.potrPris = row.cells[1].children[0].value;
				tempTableRow.prov = row.cells[2].children[0].value;
				tempTableRow.vremeOd = row.cells[3].children[0].value;
				tempTableRow.vremeDo = row.cells[4].children[0].value;
				
				if(tempTableRow.progProv == "" || tempTableRow.potrPris == "" || tempTableRow.prov == "" || tempTableRow.vremeOd == "" || tempTableRow.vremeDo == "" ){
					alert("Sva polja moraju biti popunjena!");
					cpipip.progrIPlanIntProv.redoviTabele = [];
					return false;					
				}
								
				cpipip.progrIPlanIntProv.redoviTabele.push(tempTableRow);
			}
			
			$http({
				headers: { 
			        'Accept': 'application/json',
			        'Content-Type': 'application/json' 
			    },
				method: 'POST',
				url: '/check-programme/add',
				data:cpipip.progrIPlanIntProv
			}).success(function(response){
				cpipip.data=response;

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
(function(){
	'use strict';
	
	angular
		.module("SMPuOS")
		.controller('createObavOIntProvCtrl', createObavOIntProvCtrl);
	createObavOIntProvCtrl.$inject = ['$http'];
	function createObavOIntProvCtrl($http){
		var coip=this;
		
		coip.obavOIntProv = {};
		
		coip.obavOIntProv.id = null;
		coip.obavOIntProv.timZaProveru = [];
		coip.obavOIntProv.komentari = [];
		coip.obavOIntProv.verifikovan = false;
		
		
		coip.sacuvaj = function(){
			if(!coip.obavOIntProv.oznaka || !coip.obavOIntProv.datum || !coip.obavOIntProv.vrstaProvere || !coip.obavOIntProv.poZahtevuBr || !coip.obavOIntProv.orgJedinica || !coip.obavOIntProv.nadlezniRuk || !coip.obavOIntProv.datumOd || !coip.obavOIntProv.datumDo || !coip.obavOIntProv.zahtDok)
			{
				alert("Sva polja moraju biti popunjena!");
				return false;
			}
			
			//todo za proveravace!
			
			$http({
				headers: { 
			        'Accept': 'application/json',
			        'Content-Type': 'application/json' 
			    },
				method: 'POST',
				url: '/notification/add',
				data:coip.obavOIntProv
			}).success(function(response){
				coip.data=response;

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
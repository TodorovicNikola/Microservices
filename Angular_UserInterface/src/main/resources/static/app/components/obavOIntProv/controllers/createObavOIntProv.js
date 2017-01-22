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
		
		coip.auditorOverview = {};
		coip.auditorOverview.id = null;
		coip.auditorOverview.auditors = [];
		
		$http({
			method: 'GET',
			url: '/auditor-overview/all',
		}).success(function(response){
			coip.auditorOverview=response;

			console.log(response);

		})
		.error(function(error){
			alert("Error");
			console.log(error);
		});
		
		
		coip.dodajUListu = function(imeIPrezime, oblast){
			if(coip.obavOIntProv.timZaProveru.length < 4){
				for(var i=0; i<=coip.obavOIntProv.timZaProveru.length; i++){
					if( coip.obavOIntProv.timZaProveru[i] != undefined && coip.obavOIntProv.timZaProveru[i].imeIPrezime == imeIPrezime){
						alert("Odabrani proveravac je vec ubacen u tim!");
						return false;
					}
				}
				
				var temp = {};
				temp.imeIPrezime = imeIPrezime;
				temp.funkcija = oblast;
				coip.obavOIntProv.timZaProveru.push(temp);
				
			}
		}
		
		coip.ukloni = function(imeIPrezime, oblast){
			var pozicija = -1;
			for(var i=0; i<= coip.obavOIntProv.timZaProveru.length; i++){
				if(coip.obavOIntProv.timZaProveru[i].imeIPrezime == imeIPrezime){
					pozicija = i;
					break;
				}
			}
			
			if(pozicija > -1){
				coip.obavOIntProv.timZaProveru.splice(pozicija, 1);
			}
			
		}
		
		
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
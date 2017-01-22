(function(){
	'use strict';
	
	angular
		.module("SMPuOS")
		.controller('updObavOIntProvCtrl', updObavOIntProvCtrl);
	
	updObavOIntProvCtrl.$inject = ['$http', '$stateParams'];
	function updObavOIntProvCtrl($http, $stateParams){
		var uoip=this;
		
		alert($stateParams.id);
		
		uoip.obavOIntProv = {};
		
		uoip.auditorOverview = {};
		uoip.auditorOverview.id = null;
		uoip.auditorOverview.auditors = [];
		/////////////
		$http({
			method: 'GET',
			url: '/auditor-overview/all',
		}).success(function(response){
			uoip.auditorOverview=response;

			console.log(response);

		})
		.error(function(error){
			alert("Error");
			console.log(error);
		});
		//////////
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
		///////////
		uoip.dodajUListu = function(imeIPrezime, oblast){
			if(uoip.obavOIntProv.timZaProveru.length < 4){
				for(var i=0; i<=uoip.obavOIntProv.timZaProveru.length; i++){
					if( uoip.obavOIntProv.timZaProveru[i] != undefined && uoip.obavOIntProv.timZaProveru[i].imeIPrezime == imeIPrezime){
						alert("Odabrani proveravac je vec ubacen u tim!");
						return false;
					}
				}
				
				var temp = {};
				temp.imeIPrezime = imeIPrezime;
				temp.funkcija = oblast;
				uoip.obavOIntProv.timZaProveru.push(temp);
				
			}
		}
		
		uoip.ukloni = function(imeIPrezime, oblast){
			var pozicija = -1;
			for(var i=0; i<= uoip.obavOIntProv.timZaProveru.length; i++){
				if(uoip.obavOIntProv.timZaProveru[i].imeIPrezime == imeIPrezime){
					pozicija = i;
					break;
				}
			}
			
			if(pozicija > -1){
				uoip.obavOIntProv.timZaProveru.splice(pozicija, 1);
			}
			
		}
		
		//////////
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
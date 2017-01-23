
(function (angular) {
	var documentQualityDetailModule = angular.module('app.documentQualityDetailCtrl', ['ngStorage']);
	angular.module('app.documentQualityDetailCtrl').directive("formatDate", function() {
	    return {
	        require: 'ngModel',
	        link: function(scope, elem, attr, modelCtrl) {
	            modelCtrl.$formatters.push(function(modelValue) {
	                if (modelValue){
	                    return new Date(modelValue);
	                }
	                else {
	                    return null;
	                }
	            });
	        }
	    };
	});
	var documentQualityDetailController = [ '$scope', '$http','$location','$stateParams','$localStorage','$compile',function ($scope, $http,$location,$stateParams,$localStorage,$compile){

		var documentId=$stateParams.id;
		$scope.doc={};
		$scope.documentId=documentId;
		$scope.doc.docItems=[];

		$scope.addRowForItem=function() {
			var itemsTable=(angular.element(document.getElementById('qualityItems')));
			var count= itemsTable.children().length;
			var html='<tr><td hidden><input class="form-control" ng-model="doc.docItems['+count+'].id" ></td>'+
			'<td><input class="form-control" ng-model="doc.docItems['+count+'].itemMark" ng-disabled="doc.docItems['+count+'].id || getCurrentUser().role!='+"'Sekretar'"+'"></td>'+
			'<td><input class="form-control" ng-model="doc.docItems['+count+'].itemTitle" ng-disabled="doc.docItems['+count+'].id || getCurrentUser().role!='+"'Sekretar'"+'"></td>'+
			'<td><input class="form-control" ng-model="doc.docItems['+count+'].itemRelease" ng-disabled="getCurrentUser().role!='+"'Sekretar'"+'"></td>'+
			'<td><input class="form-control"  type="date" format-date ng-model="doc.docItems['+count+'].itemDate" ng-disabled="getCurrentUser().role!='+"'Sekretar'"+'"></td>'+
			'<td><input class="form-control" ng-model="doc.docItems['+count+'].itemUsers" ng-disabled="doc.docItems['+count+'].id|| getCurrentUser().role!='+"'Sekretar'"+'"></td>'+
			'<td><button class="btn-primary" type="button" ng-click="deleteItem('+count+')" ng-disabled="getCurrentUser().role!='+"'Sekretar'"+'">Brisanje</button></td>';
			console.log(html);
			itemsTable.append(html);
			$compile(itemsTable)($scope);


		}

		$scope.documentQualityOk=function()
		{
			if ($scope.doc.docMark==null || $scope.doc.docMark=='')
			{
				alert("Morate uneti oznaku dokumenta");
				return false;
			}
			if ($scope.doc.docItems==null || $scope.doc.docItems.length==0)
			{
				alert("Morate uneti bar neki dokument");
				return false;
			}
			else
			{

				for (var i=0;i<$scope.doc.docItems.length;i++)
				{

					var item=$scope.doc.docItems[i];
					if (item!=null)
					{

						if (item.itemRelease==null || item.itemRelease=='' || item.itemMark==null  || item.itemMark=='' || item.itemDate==null || item.itemDate=='' || item.itemUsers==null || item.itemUsers==''  || item.itemTitle==null || item.itemTitle=='')
						{
							alert("Morate popuniti sva polja dokumenta, da bi ste ga uneli");
							return false;
						}
						else{

							if (!(+item.itemRelease===parseInt(item.itemRelease)))
							{
								alert("Izdanje mora biti broj");
								return false;
								
							}
						}
					}
				}
			}
			return true;
		}


		$scope.getCurrentUser=function()
		{

			return $localStorage.currentUser;
		}

		$scope.deleteItem=function(rbr)
		{
			console.log("duzina stavki pre "+ $scope.doc.docItems);
			delete $scope.doc.docItems[rbr];
		}

		$scope.getReadableDateTime=function(milliseconds)
		{
			if (!milliseconds)
				return null;
			return new Date(milliseconds).toLocaleString();	
		}


		$scope.updateDocument=function()
		{

			//$scope.doc.docDate="1485011275315";
			if (!$scope.documentQualityOk())
			{
				return;
			}
			$http({
				method: 'PUT',
				url: '/document-quality-service/documents/'+$scope.doc.id,
				data:$scope.doc
			}).success(function(response){
				if(!response)
				{
					alert("Greska, nemate prava");
				}
				$scope.data=response;

				window.location="#/qualityDocuments";
			})
			.error(function(error){
				alert("Error ");
				console.log(error);
			});
		}



		$scope.saveDocument=function()
		{
			console.log($scope.doc);
			$scope.doc.userId=$scope.getCurrentUser().id;
			//$scope.doc.docDate="1485011275315";
			if (!($scope.documentQualityOk()))
			{
				return;
			}
			$http({
				method: 'POST',
				url: '/document-quality-service/createDocument',
				data:$scope.doc
			}).success(function(response,status){
				if(!response)
				{
					alert("Greska, nemate prava");
				}
				$scope.data=response;

				window.location="#/qualityDocuments";
			})
			.error(function(error){
				alert("Error ");
				console.log(error);
			});

		}
		$scope.validateDocumentForm=function()
		{
			return true;
		}

		$scope.getDocument=function(documentId)
		{
			$http({
				method: 'GET',
				url: '/document-quality-service/documents/'+documentId
			}).success(function(response){
				$scope.doc=response;
				if($scope.doc.docItems!=null && $scope.doc.docItems.length>0)
				{
					for (var i=0;i<$scope.doc.docItems.length;i++)
					{
						$scope.addRowForItem();
					}
				}
				else{
					$scope.doc.docItems=[];
				}


			})
			.error(function(error){
				console.log(error);
			});
		}


		if(documentId)
		{
			$scope.getDocument(documentId);

		}
		else{
			$scope.doc.docItems=[];
		}




	}];
	documentQualityDetailModule.controller('documentQualityDetailCtrl', documentQualityDetailController);
}(angular));

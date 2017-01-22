
(function (angular) {
	var documentQualityDetailModule = angular.module('app.documentQualityDetailCtrl', ['ngStorage']);

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
			'<td><input class="form-control" ng-model="doc.docItems['+count+'].itemDate" ng-disabled="getCurrentUser().role!='+"'Sekretar'"+'"></td>'+
			'<td><input class="form-control" ng-model="doc.docItems['+count+'].itemUsers" ng-disabled="doc.docItems['+count+'].id|| getCurrentUser().role!='+"'Sekretar'"+'"></td>'+
			'<td><button class="btn-primary" type="button" ng-click="deleteItem('+count+')" ng-disabled="getCurrentUser().role!='+"'Sekretar'"+'">Brisanje</button></td>';
			console.log(html);
			itemsTable.append(html);
			$compile(itemsTable)($scope);
	

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

			$scope.doc.docDate="1485011275315";
			$http({
				method: 'PUT',
				url: '/document-quality-service/documents/'+$scope.doc.id,
				data:$scope.doc
			}).success(function(response){

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

			$http({
				method: 'POST',
				url: '/document-quality-service/createDocument',
				data:$scope.doc
			}).success(function(response,status){
				if(!response)
				{
					alert("Error when posting document, permission denied");
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
			console.log("OVDE SAM");
			$scope.getDocument(documentId);
		
		}
		else{
			$scope.doc.docItems=[];
		}




	}];
	documentQualityDetailModule.controller('documentQualityDetailCtrl', documentQualityDetailController);
}(angular));

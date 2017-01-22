
(function (angular) {
	var documentsQualityModule = angular.module('app.documentsQualityCtrl', []);

	var documentsQualityController = [ '$scope', '$http','$location','$stateParams',function ($scope, $http,$location,$stateParams){

		$scope.getReadableDateTime=function(milliseconds)
		{
			if (!milliseconds)
				return null;
			return new Date(milliseconds).toLocaleString();	
		}

		$scope.getData=function(){

			$http({
				method: 'GET',
				url: '/document-quality-service/documents'
			}).success(function(response){
				$scope.data=response;
				console.log(response);
			})
			.error(function(error){
				console.log(error);
			});

		}
		$scope.deleteDoc=function(documentId,rbr)
		{
			$http({
				method: 'DELETE',
				url: '/document-quality-service/documents/'+documentId
			}).success(function(response){
				
				console.log(response);
				if (response){
					
					$scope.data.splice(rbr,1);
				}
			})
			.error(function(error){
				console.log(error);
			});
			
			
		}


		$scope.getDocument=function(documentId)
		{
			$http({
				method: 'GET',
				url: '/document-quality-service/documents/'+documentId
			}).success(function(response){
				$scope.doc=response;
				console.log(response);
			})
			.error(function(error){
				console.log(error);
			});
		}


		
		$scope.getData();
	

	}];
	documentsQualityModule.controller('documentsQualityCtrl', documentsQualityController);
}(angular));

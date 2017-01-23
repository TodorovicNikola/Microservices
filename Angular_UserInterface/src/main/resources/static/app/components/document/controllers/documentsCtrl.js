
(function (angular) {
	var documentsModule = angular.module('app.documentsCtrl', ['ngStorage']);

	var documentsController = [ '$scope', '$http','$location','$stateParams','$localStorage',function ($scope, $http,$location,$stateParams,$localStorage){

		$scope.getReadableDateTime=function(milliseconds)
		{
			if (!milliseconds)
				return null;
			return new Date(milliseconds).toLocaleString();	
		}

		$scope.getData=function(){

			$http({
				method: 'GET',
				url: '/document-task-service/documents?firstName='+$localStorage.currentUser.firstName+'&lastName='+$localStorage.currentUser.lastName+"&role="+$localStorage.currentUser.role,
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
				url: '/document-task-service/documents/'+documentId
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
				url: '/document-task-service/documents/'+documentId
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
	documentsModule.controller('documentsCtrl', documentsController);
}(angular));

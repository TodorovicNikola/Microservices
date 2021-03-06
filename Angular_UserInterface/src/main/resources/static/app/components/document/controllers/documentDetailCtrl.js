
(function (angular) {
	var documentDetailModule = angular.module('app.documentDetailCtrl', ['ngStorage']);
	angular.module('app.documentDetailCtrl').directive("formatDate", function() {
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
	
	var documentDetailController = [ '$scope', '$http','$location','$stateParams','$localStorage',function ($scope, $http,$location,$stateParams,$localStorage){

		/*$scope.writeAuthor=function()
		{
			var user=$localStorage.currentUser;
			return user==null?"":(user.firstName + " " + user.lastName);
		}*/
		$scope.writeAuthor=function()
		{
			var user=$localStorage.currentUser;
			return user==null?"":(user.lastName + " " + user.firstName);
		}



		$scope.getReadableDateTime=function(milliseconds)
		{
			if (!milliseconds)
				return null;
			return new Date(milliseconds).toLocaleString();	
		}

		var documentId=$stateParams.id;
		$scope.documentId=documentId;
		$scope.doc={};
		$scope.doc.taskCreatedBy=$scope.writeAuthor();

		$scope.composeArrayFields=function()
		{
			var taskDeliveredTo=[];
			taskDeliveredTo.push($scope.taskDeliveredTo1);
			taskDeliveredTo.push($scope.taskDeliveredTo2);
			taskDeliveredTo.push($scope.taskDeliveredTo3);

			var taskTemplates=[];
			taskTemplates.push($scope.templateMember1);
			taskTemplates.push($scope.templateMember2);
			taskTemplates.push($scope.templateMember3);
			taskTemplates.push($scope.templateMember4);

			var taskTeam=[];
			taskTeam.push($scope.teamMember1);
			taskTeam.push($scope.teamMember2);
			taskTeam.push($scope.teamMember3);

			$scope.doc.taskTeam=taskTeam;
			$scope.doc.taskDeliveredTo=taskDeliveredTo;
			$scope.doc.taskTemplates=taskTemplates;
		}

		$scope.deComposeArrayFields=function()
		{


			$scope.taskDeliveredTo1=$scope.doc.taskDeliveredTo[0];
			$scope.taskDeliveredTo2=$scope.doc.taskDeliveredTo[1];
			$scope.taskDeliveredTo3=$scope.doc.taskDeliveredTo[2];


			$scope.teamMember1=$scope.doc.taskTeam[0];
			$scope.teamMember2=$scope.doc.taskTeam[1];
			$scope.teamMember3=$scope.doc.taskTeam[2];


			$scope.templateMember1=$scope.doc.taskTemplates[0];
			$scope.templateMember2=$scope.doc.taskTemplates[1];
			$scope.templateMember3=$scope.doc.taskTemplates[2];
			$scope.templateMember4=$scope.doc.taskTemplates[3];


		}

		$scope.checkEmpty=function(objx)
		{
			if (objx==null || objx=="")
				return true;
			return false;
		}

		$scope.dummyDatum=function()
		{
			//$scope.dueDateView="2018-06-29T16:52:48.000Z";
		}

		$scope.checkDoc=function()
		{
			if ($scope.doc.status=='zavrsen')
			{
				if ($scope.checkEmpty($scope.doc.taskMark))
				{
					alert("Unesite oznaku");
					return false;
				}

				if ($scope.checkEmpty($scope.doc.taskTitle))
				{
					alert("Naslov morate popuniti");
					return false;
				}
				if ($scope.checkEmpty($scope.doc.taskDueDate))
				{
					alert("Rok morate popuniti");
					return false;
				}
				if ($scope.checkEmpty($scope.doc.taskDescription))
				{
					alert("Opis morate popuniti");
					return false;
				}
				if ($scope.checkEmpty($scope.doc.taskCarrier))
				{
					alert("Nosioca morate popuniti");
					return false;
				}
				var stat=0;
				for (var i=0;i<$scope.doc.taskTeam.length;i++)
				{
					if ($scope.doc.taskTeam[i]!=null && $scope.doc.taskTeam[i]!="")
						stat=1;
				}
				if (stat==0)
				{ 
					alert("Clana tima morate popuniti");
					return false;
				}



				if ($scope.doc.taskTemplates==null || $scope.doc.taskTemplates.length==0)
				{
					alert("Podlogu dokumenta morate popuniti");
					return false;
				}


				return true;
			}
			else
			{
				if ($scope.checkEmpty($scope.doc.taskMark))
				{
					alert("Unesite oznaku");
					return false;
				}
				return true;
			}


		}

		$scope.updateDocument=function()
		{
			$scope.composeArrayFields();
			
			if (!($scope.checkDoc()))
			{
				return;
			}
			$http({
				method: 'PUT',
				url: '/document-task-service/documents/'+$scope.doc.id,
				data:$scope.doc
			}).success(function(response){
				$scope.data=response;
				//console.log(response);
				window.location="#/documents";
			})
			.error(function(error){
				alert("Error ");
				console.log(error);
			});
		}



		$scope.saveDocument=function()
		{
			$scope.composeArrayFields();
			
			$scope.doc.status==null?$scope.doc.status="pocet":$scope.doc.status;
			if (!($scope.checkDoc()))
			{
				return;
			}
			$http({
				method: 'POST',
				url: '/document-task-service/createDocument',
				data:$scope.doc
			}).success(function(response,status){
				if(!response)
				{
					alert("Error when posting document, permission denied");
				}
				$scope.data=response;
				window.location="#/documents";
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
				url: '/document-task-service/documents/'+documentId
			}).success(function(response){
				$scope.doc=response;
				$scope.deComposeArrayFields();
				//$scope.dueDateView=$scope.getReadableDateTime($scope.doc.taskDueDate);
				//$scope.dateView=$scope.getReadableDateTime($scope.doc.taskDate);
				$scope.allowEditing=($scope.doc.status=='pocet');

				//$scope.doc.taskDateView=$scope.getReadableDateTime()
				console.log(response);
			})
			.error(function(error){
				console.log(error);
			});
		}

		if(documentId)
		{
			$scope.getDocument(documentId);

		}
		$scope.statuses=['pocet','zavrsen'];



	}];
	documentDetailModule.controller('documentDetailCtrl', documentDetailController);
}(angular));

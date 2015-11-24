(function() {
	var app = angular.module('tinypet', []);
	app.controller("tinyCtrl", function($scope, $http) {
		var ctrl = this;
		ctrl.submitPet = false;
		ctrl.listPet = false;
		ctrl.petText = "";
		ctrl.petTitle = "";
		ctrl.submited = false;
		ctrl.voteNb = 0;
		ctrl.voted = {};
		
		ctrl.vote = function() {
			if (voteNb = 0) {
				return null;
			} else {
				if ($.inArray(ctrl.voteNb, voted)) {
					return null;
				}
			}
			ctrl.voted.push(ctrl.voteNb);
		}
		
		ctrl.submit = function() {
			ctrl.submitPet = true;
			ctrl.listPet = false;
		}
		
		ctrl.list = function() {
			ctrl.submitPet = false;
			ctrl.listPet = true;
		}
		
		ctrl.submitPetition = function() {
			//send petition to servlet for datastore add
			ctrl.submited = true;			
			$scope.petition = {};
			$scope.petition = {"title":ctrl.petTitle, "text":ctrl.petText};
			$scope.createPet = function()
	    	{
	    		$http({
	    			method: 'POST',
	    			url: '/createpetition',
	    			headers: {'Content-Type': 'application/json'},
	    			data: $scope.petition
	    			}).success(function(data){
	    					$scope.status = data;
	    					console.log(data);
	    			});
	    			console.log("Ajout success");
	    	}();	
		}
	})
})();
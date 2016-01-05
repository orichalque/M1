(function() {
  var app = angular.module('DiceLauncher', []);
  app.controller("DiceController", function($scope, $http) {
    var ctrl = this;
    ctrl.newScore = {};
    ctrl.score = 0;
    ctrl.name = 0;
    ctrl.nbOfThrows = 0;
    ctrl.name="";
    ctrl.submited = false;   
    ctrl.submit = function() {
    	if (ctrl.submited == false) {
    		ctrl.submited = true;
    	} else {
    		ctrl.submited = false;
    	}
    }    
    ctrl.throwDice = function() {
      if (ctrl.nbOfThrows < 10) {
        ctrl.nbOfThrows ++;
        if ((Math.floor((Math.random() * 6) + 1) == 6)) {
          ctrl.score = ctrl.score + 10;
        }
      }
    }
    ctrl.addScore = function(){
    	ctrl.submited = true;
    	console.log(ctrl.name);
    	console.log(ctrl.score);
    	$scope.person = {};
    	$scope.person = {"name":ctrl.name, "score":ctrl.score};
    	$scope.addUser = function()
    	{
    		$http({
    			method: 'POST',
    			url: '/dicelaunch',
    			headers: {'Content-Type': 'application/json'},
    			data: $scope.person
    			}).success(function(data)
    				{
    					$scope.status = data;
    				});
    		}();
    	}
    }
  )})();

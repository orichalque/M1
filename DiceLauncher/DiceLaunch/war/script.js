// Code goes here

(function() {
  var app = angular.module('DiceLauncher', []);
  app.controller("DiceController", function($scope, $http) {
    var ctrl = this;
    ctrl.newScore = {};
    ctrl.score = 0;
    ctrl.name = 0;
    ctrl.nbOfThrows = 0;
    ctrl.name="";
    ctrl.throwDice = function() {
      if (ctrl.nbOfThrows < 10) {
        ctrl.nbOfThrows ++;
        if ((Math.floor((Math.random() * 6) + 1) == 6)) {
          ctrl.score = ctrl.score + 10;
        }
      }
    }
    
    ctrl.addScore = function(){
    	console.log(ctrl.name);
    	console.log(ctrl.score);
    	$scope.person = {};
    	$scope.person = {"name":ctrl.name, "score":ctrl.score};
    	$scope.addUser = function()
    	{
    		$http({
    			method: 'POST',
    			url: 'http://localhost:8888/dicelaunch',
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

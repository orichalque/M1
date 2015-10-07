(function() {
  var app=angular.module('score', []);
  app.controller("ScoreController", [ "$http", function($http) {
    var endpoint = "https://1-dot-tp1bis-1068.appspot.com/_ah/api/entityendpoint/v1/entity";
    
    ctrl = this;
    ctrl.score = {};
    
    $http.get(endpoint).then(function(datas) {
      ctrl.scores = datas.data.items;
    }, function(error) {
      console.log("Error");
    });
    
    ctrl.display=function(){
      console.log(ctrl.scores);
    };
  }]);
})();


// Code goes here

function init() {
        "use strict";
        var ROOT = 'https://1-dot-tp1bis-1068.appspot.com/_ah/api';
        gapi.client.load('entityendpoint', 'v1', function() {
          listScores();
        }, ROOT);
  
}

function listScores() {
      gapi.client.entityendpoint.listEntity().execute(function(resp) {
      console.log("liste des scores");
      console.log(resp.items[1]);
      return resp;
  });
}




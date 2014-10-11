hiit.controller("MainController", [ "$scope", function($scope) {
	$scope.message = "you made it!";

	var worker = new Worker('webworkers/appCacheWorker.js');
	var appCache = window.applicationCache;

	appCache.addEventListener('updateready', function(e) {
	    if (window.applicationCache.status == window.applicationCache.UPDATEREADY) {
	      // Browser downloaded a new app cache.
	      if (confirm('A new version of this site is available. Load it?')) {
	        window.location.reload();
	      }
	    } else {
	      // Manifest didn't changed. Nothing new to server.
	    }
	  }, false);
	
	worker.addEventListener('message', function(e) {
		appCache.update(); // check for update, event will fire if ready

		worker.postMessage('back at you');
	}, false);

	worker.postMessage('start it off'); // Send data to our worker.

} ]);
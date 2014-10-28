hiit.controller("MainController", [ "$scope", function($scope) {
	$scope.message = "you made it!";

	var worker = new Worker('static/angular_components/js/webworkers/appCacheWorker.js');
	var appCache = window.applicationCache;

	var onError = function(e) {
		console.log("Error: line ", e.lineno, " in ", e.filename, ": ", e.message);
	};
	
	appCache.addEventListener('updateready', function(e) {
	      // Browser downloaded a new app cache.
	      if (confirm('A new version of this site is available. Load it?')) {
	        window.location.reload(true);
	      }
	  }, false);
	
	worker.onmessage = function() {
		appCache.update(); // check for update, event will fire if ready

		worker.postMessage('back at you');
	};

	setTimeout(function() {
		worker.postMessage('start it off'); // Send data to our worker.
	}, 10000);

} ]);
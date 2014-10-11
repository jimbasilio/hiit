self.addEventListener('message', function(e) {
  setTimeout(function() {
	 self.postMessage("back at you"); 
  }, 10000);
}, false);
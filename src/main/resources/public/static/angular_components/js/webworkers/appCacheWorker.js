self.onmessage = function(window_reference) {
	setTimeout(function() {
		self.postMessage('back at you');
	}, 10000);
};

hiit.controller("ProgramController", ["$scope", "$q", function($scope, $q) {
  $scope.page = {
		  programs : {}
  };
  
  var fetchPrograms = function() {
	  
  },
  initialize = function() {
	  
  };
  
  $q.all(fetchPrograms).then(initialize);
}]);
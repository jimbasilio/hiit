var hiit = angular.module('hiit', []);
  
springboot.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/program', {
        templateUrl: 'templates/program.html',
        controller: 'ProgramController'
      }).
      otherwise({
        redirectTo: '/'
      });
  }]);
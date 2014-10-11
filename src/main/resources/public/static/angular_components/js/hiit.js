var hiitApp = angular.module('hiit', [ 'ngRoute' ]);

var prefix = 'static/angular_components/js/templates/'

hiitApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/main', {
		templateUrl : prefix + 'main.html',
		controller : 'MainController'
	}).when('/program', {
		templateUrl : prefix + 'program.html',
		controller : 'ProgramController'
	}).when('/about', {
		templateUrl : prefix + 'about.html',
		controller : 'AboutController'
	}).when('/contact', {
		templateUrl : prefix + 'contact.html',
		controller : 'ContactController'
	}).otherwise({
		templateUrl : prefix + 'main.html',
		controller : 'MainController'
	});
} ]);
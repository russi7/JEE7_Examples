angular.module('myApp.services', ['ngResource'])
	.factory('AngularIssues', function($resource) {
		return $resource('/rest/dummy', {});
	});
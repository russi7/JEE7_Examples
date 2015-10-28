var app=angular.module("app",['ui.grid']);

app.constant("helloWorld","Hello World!");

app.controller("testController", ['$scope', '$log', '$http', function($scope, $log, $http) {
	$scope.message = "Hello World!";
	
	
	$http({
		method: "GET", 
		url: "http://localhost:8080/apiImpl/rest/dummy"
	}).success(function(data, status, headers, config) {
		$scope.gridData = data;
	}).error(function(data, status, headers, config) {
		$scope.message = "ERROR " + status;
	});
	
	$scope.changeMessage=function() {	
		
		$http({
			method: "GET", 
			url: "http://localhost:8080/apiImpl/rest/dummy/" + $scope.dummy.id
		}).success(function(data, status, headers, config) {
			$scope.dummy.name = data.name;
		}).error(function(data, status, headers, config) {
			$scope.dummy.name = "ERROR " + status;
		});
		
		$log.debug("Name changed");
	}
	
}]);
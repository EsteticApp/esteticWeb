'use strict';

angular.module('myApp.Inicio', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/Inicio', {
    templateUrl: 'Inicio/Inicio.html',
    controller: 'InicioCtrl'
  });
}])

.controller('InicioCtrl', [function() {

}])


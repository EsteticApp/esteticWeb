'use strict';

angular.module('myApp.Opciones', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/Opciones', {
    templateUrl: 'Opciones/Opciones.html',
    controller: 'OpcionesCtrl'
  });
}])

.controller('OpcionesCtrl', [function() {

}]);
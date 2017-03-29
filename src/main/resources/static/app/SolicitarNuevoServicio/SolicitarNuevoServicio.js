'use strict';

angular.module('myApp.SolicitarNuevoServicio', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/SolicitarNuevoServicio', {
                    templateUrl: 'SolicitarNuevoServicio/SolicitarNuevoServicio.html',
                    controller: 'ControladorSolicitarNuevoServicio'
                });
            }])

        
        .controller('ControladorSolicitarNuevoServicio', ['$scope', function ($scope) {
                
        }]);

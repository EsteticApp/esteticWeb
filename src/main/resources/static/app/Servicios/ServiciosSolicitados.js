'use strict';

angular.module('myApp.ServiciosSolicitados', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/ServiciosSolicitados', {
                    templateUrl: 'Servicios/ServiciosSolicitados.html',
                    controller: 'ControladorServiciosSolicitados'
                });
        }])

        .controller('ControladorServiciosSolicitados', ['$scope', '$rootScope', '$http', '$location', function ($scope, $rootScope, $http, $location,$mdDialog) {
              $scope.toppings = [
                { name: 'Pepperoni', wanted: true },
                { name: 'Sausage', wanted: false },
                { name: 'Black Olives', wanted: true },
                { name: 'Green Peppers', wanted: false }
              ];
            }
        ]);




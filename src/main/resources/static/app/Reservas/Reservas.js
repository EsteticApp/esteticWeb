 'use strict';

angular.module('myApp.Reservas', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/Reservas', {
                    templateUrl: 'Reservas/Reservas.html',
                    controller: 'ControladorReservas'
                });
            }])

        .controller('ControladorReservas', ['$scope', '$http', '$location', function ($scope, $http, $location) {




        }]);
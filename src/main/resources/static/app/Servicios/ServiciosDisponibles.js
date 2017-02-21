'use strict';

angular.module('myApp.ServiciosDisponibles', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/ServiciosDisponibles', {
                    templateUrl: 'Servicios/ServiciosDisponibles.html',
                    controller: 'ControladorServiciosDisponibles'
                });
            }])


        .controller('ControladorServiciosDisponibles', ['$scope', '$rootScope', '$http', '$location', function ($scope, $rootScope, $http, $location) {
            }
        ]);
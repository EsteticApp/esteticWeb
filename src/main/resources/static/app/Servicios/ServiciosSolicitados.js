'use strict';

angular.module('myApp.ServiciosSolicitados', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/ServiciosSolicitados', {
                    templateUrl: 'Servicios/ServiciosSolicitados.html',
                    controller: 'ControladorServiciosSolicitados'
                });
            }])


        .controller('ControladorServiciosSolicitados', ['$scope', '$rootScope', '$http', '$location', function ($scope, $rootScope, $http, $location) {

            }
        ]);




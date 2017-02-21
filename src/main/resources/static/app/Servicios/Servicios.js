'use strict';

angular.module('myApp.Servicios', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/Servicios', {
                    templateUrl: 'Servicios/Servicios.html',
                    controller: 'ControladorServicios'
                });
            }])


        .controller('ControladorServicios', ['$scope', '$rootScope', '$http', '$location', function ($scope, $rootScope, $http, $location) {
            }
        ]);
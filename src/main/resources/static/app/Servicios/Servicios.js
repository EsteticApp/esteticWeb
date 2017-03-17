 'use strict';

angular.module('myApp.Servicios', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/Servicios', {
                    templateUrl: 'Servicios/Servicios.html',
                    controller: 'ControladorServicios'
                });
            }])

        .controller('ControladorServicios', ['$scope', '$http', '$location', function ($scope, $http, $location) {

            $scope.sPeluqueria = function(){
                $location.path("/ServiciosDisponibles");
                localStorage.catSeleccionada = "Peluqueria";
            };

            $scope.sUnas = function(){
                $location.path("/ServiciosDisponibles");
                localStorage.catSeleccionada = "Unas";
            };

            $scope.sDepilacion = function(){
                $location.path("/ServiciosDisponibles");
                localStorage.catSeleccionada = "Depilacion";
            };

            $scope.sMasajes = function(){
                $location.path("/ServiciosDisponibles");
                localStorage.catSeleccionada = "Masajes";
            };


        }]);
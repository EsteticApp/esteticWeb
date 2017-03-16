 'use strict';

angular.module('myApp.Servicios', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/Servicios', {
                    templateUrl: 'Servicios/Servicios.html',
                    controller: 'ControladorServicios'
                });
            }])

        .controller('ControladorServicios', ['$scope', '$rootScope', '$http', '$location', function ($scope, $rootScope, $http, $location) {

            $scope.sPeluqueria = function(){
                console.log("Categoria seleccionada: Peluqueria");
                $location.path("/ServiciosDisponibles");
                $scope.categoriaSeleccionada="Peluqueria";
            };

            $scope.sUnas = function(){
                console.log("Categoria seleccionada: Unas");
                $location.path("/ServiciosDisponibles");
                $scope.categoriaSeleccionada="Unas";
            };

            $scope.sDepilacion = function(){
                console.log("Categoria seleccionada: Depilacion");
                $location.path("/ServiciosDisponibles");
                $scope.categoriaSeleccionada="Depilacion";
            };

            $scope.sMasajes = function(){
                console.log("Categoria seleccionada: Masajes");
                $location.path("/ServiciosDisponibles");
                $scope.categoriaSeleccionada="Masajes";
            };


        }]);
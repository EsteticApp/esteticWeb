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
                $location.path("/ServiciosDisponibles");
                $rootScope.categoriaSeleccionada="Peluqueria";
                localStorage.catSeleccionada = "Peluqueria"
                console.log($scope.categoriaSeleccionada);
            };

            $scope.sUnas = function(){
                $location.path("/ServiciosDisponibles");
                $rootScope.categoriaSeleccionada="Unas";
                localStorage.catSeleccionada = "Unas"
                console.log($scope.categoriaSeleccionada);
            };

            $scope.sDepilacion = function(){
                $location.path("/ServiciosDisponibles");
                $rootScope.categoriaSeleccionada="Depilacion";
                localStorage.catSeleccionada = "Depilacion"
                console.log($scope.categoriaSeleccionada);
            };

            $scope.sMasajes = function(){
                $location.path("/ServiciosDisponibles");
                $rootScope.categoriaSeleccionada="Masajes";
                localStorage.catSeleccionada = "Masajes"
                console.log($scope.categoriaSeleccionada);
            };


        }]);
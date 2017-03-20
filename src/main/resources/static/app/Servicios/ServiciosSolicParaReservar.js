'use strict';

angular.module('myApp.ServiciosSolicParaReservar', ['ngRoute', 'ngMaterial'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/ServiciosSolicParaReservar', {
                    templateUrl: 'Servicios/ServiciosSolicParaReservar.html',
                    controller: 'ControladorServiciosSolicParaReservar'
                });
            }])


        .controller('ControladorServiciosSolicParaReservar', ['$resource','$scope', '$rootScope', '$http', '$location', 'estilistasCategorias', 'estCat', function ($resource, $scope, $rootScope, $http, $location, estilistasCategorias, estCat) {

            $scope.select = localStorage.reservar;

            }]);




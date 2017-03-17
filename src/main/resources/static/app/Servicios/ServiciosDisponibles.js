'use strict';

angular.module('myApp.ServiciosDisponibles', ['ngRoute', 'ngMaterial'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/ServiciosDisponibles', {
                    templateUrl: 'Servicios/ServiciosDisponibles.html',
                    controller: 'ControladorServiciosDisponibles'
                });
            }])


        .controller('ControladorServiciosDisponibles', ['$resource','$scope', '$rootScope', '$http', '$location', 'estilistasCategorias', 'estCat', function ($resource, $scope, $rootScope, $http, $location, estilistasCategorias, estCat) {
            $scope.estilistas;
            $scope.status = '  ';
                $scope.catselect = localStorage.catSeleccionada;
                $scope.pedir = function(){
                      var esti = $resource('/estilistas/'+localStorage.catSeleccionada+'/:rolEstilista');
                      $scope.estilistas = esti.query();
                };
                $scope.estilistaSelect = function(estilista) {
                    $location.path("/ServiciosSolicitados");
                    localStorage.estilistaSelect = estilista;
                };

            }]);




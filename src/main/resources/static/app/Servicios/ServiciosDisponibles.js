'use strict';

angular.module('myApp.ServiciosDisponibles', ['ngRoute', 'ngMaterial'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/ServiciosDisponibles', {
                    templateUrl: 'Servicios/ServiciosDisponibles.html',
                    controller: 'ControladorServiciosDisponibles'
                });
            }])


        .controller('ControladorServiciosDisponibles', ['$resource','$scope', '$rootScope', '$http', '$location', 'estilistasCategorias', 'estCat','estilistasServicios', function ($resource, $scope, $rootScope, $http, $location, estilistasCategorias, estCat, estilistasServicios) {
            $scope.estilistas;
            $scope.status = '  ';
                $scope.catselect = localStorage.catSeleccionada;
                $scope.pedir = function(){
                      var esti = $resource('/estilistas/category/'+localStorage.catSeleccionada+'/:rolEstilista');
                      $scope.estilistas = esti.query();

                      /*var esti = $resource('/estilistas/id/');
                      $scope.servicios = esti.query();*/

                };
                $scope.estilistaSelect = function(estilista) {
                    $location.path("/ServiciosSolicitados");
                    localStorage.estilistaSelect = estilista;
                    $rootScope.professionalSelected = estilista;
                };

            }]);




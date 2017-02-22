'use strict';

angular.module('myApp.Professional', ['ngRoute', 'ngMaterial'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/Professional', {
                    templateUrl: 'Professional/Professional.html',
                    controller: 'ControladorProfessional'
                });
            }])


        .controller('ControladorProfessional', ['$scope', '$rootScope', '$http', '$location', '$timeout',function ($scope, $rootScope, $http, $location, $timeout) {
              $scope.servicio= null;
              //$scope.servicios = null;

              $scope.cargarServiciosEstilista = function() {

                // Use timeout to simulate a 650ms request.
                return $timeout(function() {

                  $scope.servicios =  $scope.servicios  || [

                    { id: 1, name: 'Corte' },
                    { id: 2, name: 'Cepillado' },
                    { id: 3, name: 'Tinte' },
                    { id: 4, name: 'Mechas' },
                    { id: 5, name: 'Recogidos' }
                  ];

                }, 650);
              };

              $scope.solicitarServicio = function(){
                  console.log("Solicitar servicio");
                  $location.path("/ServiciosSolicitados");
              }
            }
        ]);
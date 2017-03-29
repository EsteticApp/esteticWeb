'use strict';

angular.module('myApp.ServiciosSolicitados', ['ngRoute', 'ngMaterial'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/ServiciosSolicitados', {
                    templateUrl: 'Servicios/ServiciosSolicitados.html',
                    controller: 'ControladorServiciosSolicitados'
                });
        }])

        .controller('ControladorServiciosSolicitados', ['$resource','$scope', '$rootScope', '$http', '$location', function ($resource,$scope, $rootScope, $http, $location) {
              $scope.estilista=localStorage.estilistaSelect;
              var esti = $resource('/estilistas/id/'+localStorage.estilistaSelect);
              $scope.servicios = esti.query();

              //$scope.precios = ['$17.000', '$15.000', '$12.000', '$5.000', '$10.000', '$20.000'];



                $scope.selection=[];

                $scope.servicioSelect = function servicioSelect(servicio) {
                  var idx = $scope.selection.indexOf(servicio);
                  //console.log("Servicio: " + servicio);
                  if (idx > -1) {
                    // is currently selected
                    $scope.selection.splice(idx, 1);
                   }
                   else {
                     // is newly selected
                     $scope.selection.push(servicio);

                     var p = $resource('/precios/:id', {id: '@id'});
                     $scope.precios = p.query();

                   }

                   console.log("Selection: " + $scope.selection);
                };

                $scope.reservar = function(selection){
                    $location.path("/ServiciosSolicParaReservar");
                    localStorage.reservar = selection;
                    console.log("Selectionlocal: " + localStorage.reservar);
                };

        }]);




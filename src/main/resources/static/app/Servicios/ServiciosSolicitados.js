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

              //$scope.servicio = $scope.servicios;

                $scope.selection=[];

                $scope.servicioSelect = function servicioSelect(servicio) {
                  var idx = $scope.selection.indexOf(servicio);
                  console.log(idx);
                  if (idx > -1) {
                    // is currently selected
                    $scope.selection.splice(idx, 1);
                   }
                   else {
                     // is newly selected
                     $scope.selection.push(servicio);
                   }


                };



        }]);




'use strict';

angular.module('myApp.ServiciosSolicitados', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/ServiciosSolicitados', {
                    templateUrl: 'Servicios/ServiciosSolicitados.html',
                    controller: 'ControladorServiciosSolicitados'
                });
        }])

        .controller('ControladorServiciosSolicitados', ['$resource','$scope', '$rootScope', '$http', '$location', function ($resource,$scope, $rootScope, $http, $location,$mdDialog) {
              $scope.estilista=localStorage.estilistaSelect;
              var esti = $resource('/estilistas/id/'+localStorage.estilistaSelect);
              $scope.servicios = esti.query();
            }
        ]);




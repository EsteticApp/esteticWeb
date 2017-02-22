'use strict';

angular.module('myApp.Opciones', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/Opciones', {
                    templateUrl: 'Opciones/Opciones.html',
                    controller: 'OpcionesCtrl'
                });
            }])

        .controller('OpcionesCtrl', ['$scope', '$rootScope', function ($scope, $rootScope) {
                $rootScope.value = false;
                $rootScope.users = {}
                $scope.role = function (rol) {
                    $rootScope.users.role = rol;
                    console.log($rootScope.users.role);
                }
            }]);
'use strict';

angular.module('myApp.Registrar', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/Registrar', {
                    templateUrl: 'Registrar/Registrar.html',
                    controller: 'ControladorRegistrar'
                });
            }])


        .controller('ControladorRegistrar', ['$scope', '$rootScope', 'registrarService', '$location', function ($scope, $rootScope, registrarService, $location) {
                $scope.users = {};
                $scope.value = false;
                $scope.RegistrarUsu = function () {
                    $scope.users.role="CLIENTE"
                    registrarService.Registrar($scope.users);
                    console.log($scope.users)
                    $scope.value = true;
                }
            }]);
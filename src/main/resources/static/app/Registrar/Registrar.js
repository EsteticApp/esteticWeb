'use strict';

angular.module('myApp.Registrar', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/Registrar', {
                    templateUrl: 'Registrar/Registrar.html',
                    controller: 'ControladorRegistrar'
                });
            }])


        .controller('ControladorRegistrar', ['$scope', '$rootScope', 'registrarService', '$location', function ($scope, $rootScope, registrarService, $location) {
                
                $scope.RegistrarUsu = function () {
                    registrarService.Registrar($rootScope.users);
                    console.log($rootScope.users)
                    $rootScope.value = true;
                    $location.path("/Login");
                }
            }]);
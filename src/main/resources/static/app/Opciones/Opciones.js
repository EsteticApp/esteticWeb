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
                $rootScope.users = {};
                $rootScope.users.roles_idRole={}
                $rootScope.users.idCard="";
                $rootScope.users.state=1;
//                $rootScope.users.photo=null;
                $rootScope.photo={}
                $scope.role = function (id,rol) {
                    $rootScope.users.roles_idRole.nombre = rol;
                    $rootScope.users.roles_idRole.idRole = id;
                    $rootScope.users.roles_idRole.descripcion = "";
                    console.log($rootScope.users.Roles_idRole);
                }
            }]);
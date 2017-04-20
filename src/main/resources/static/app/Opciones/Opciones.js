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
                $rootScope.users.role=""
                $rootScope.users.idCard="";
                $rootScope.users.state=1;
                $rootScope.users.type="";
//                $rootScope.users.photo=null;
                $rootScope.photo={}
                $scope.role = function (id,rol) {
                    $rootScope.users.role= rol;
                    $rootScope.users.type= rol;
                    console.log($rootScope.users.role);
                }
            }]);
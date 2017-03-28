'use strict';

angular.module('myApp.Perfil', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/Perfil', {
                    templateUrl: 'Perfil/Perfil.html',
                    controller: 'ControladorPerfil'
                });
            }])


        .controller('ControladorPerfil', ['$scope', '$rootScope', '$http', '$location', function ($scope, $rootScope, $http, $location) {
            }
        ]);
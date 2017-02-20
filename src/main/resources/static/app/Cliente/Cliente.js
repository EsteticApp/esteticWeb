'use strict';

angular.module('myApp.Cliente', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/Cliente', {
                    templateUrl: 'Cliente/Cliente.html',
                    controller: 'ControladorCliente'
                });
            }])


        .controller('ControladorCliente', ['$scope', '$rootScope', '$http', '$location', function ($scope, $rootScope, $http, $location) {
            }
        ]);
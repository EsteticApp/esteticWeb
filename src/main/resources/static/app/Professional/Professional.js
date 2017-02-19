'use strict';

angular.module('myApp.Professional', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/PROFESSIONAL', {
                    templateUrl: 'Professional/Professional.html',
                    controller: 'ControladorProfessional'
                });
            }])


        .controller('ControladorProfessional', ['$scope', '$rootScope', '$http', '$location', function ($scope, $rootScope, $http, $location) {
            }
        ]);
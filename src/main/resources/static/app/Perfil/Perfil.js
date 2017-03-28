'use strict';

angular.module('myApp.Perfil', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/Perfil', {
                    templateUrl: 'Perfil/Perfil.html',
                    controller: 'ControladorPerfil'
                });
            }])


        .controller('ControladorPerfil', ['$scope', '$rootScope', '$http', '$location','usuario', function ($scope, $rootScope, $http, $location,usuario) {
                $scope.user=usuario.GET($rootScope.email);
                console.log($scope.user);
            }
        ]);
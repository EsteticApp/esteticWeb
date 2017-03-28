'use strict';

angular.module('myApp.Perfil', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/Perfil', {
                    templateUrl: 'Perfil/Perfil.html',
                    controller: 'ControladorPerfil'
                });
            }])


        .controller('ControladorPerfil', ['$scope', '$rootScope', '$http', '$location','usuarioPost', function ($scope, $rootScope, $http, $location,usuarioPost) {
                console.log($rootScope.EmailString);
                $scope.user=usuarioPost.Usuario($rootScope.EmailString);
                console.log($scope.user);
            }
        ]);
        
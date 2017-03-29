'use strict';

angular.module('myApp.Perfil', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/Perfil', {
                    templateUrl: 'Perfil/Perfil.html',
                    controller: 'ControladorPerfil'
                });
            }])


        .controller('ControladorPerfil', ['$scope', '$rootScope', '$http', '$location','usuarioPost','usuarioPhoto', function ($scope, $rootScope, $http, $location,usuarioPost,usuarioPhoto) {
                console.log($rootScope.EmailString);
                $scope.user=usuarioPost.Usuario($rootScope.EmailString);
                $scope.user.photo=usuarioPhoto.get($rootScope.EmailString);
                console.log($scope.user);
            }
        ]);
        
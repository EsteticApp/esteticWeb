'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
    'ngRoute',
    'myApp.Cliente',
    'myApp.Login',
    'myApp.Servicios',
    'myApp.ServiciosDisponibles',
    'myApp.version',
    'myApp.Professional',
    'myApp.Opciones',
    'myApp.Registrar',
    'services.modulo'
]).
        config(['$locationProvider', '$routeProvider', '$httpProvider', function ($locationProvider, $routeProvider, $httpProvider) {
                $locationProvider.hashPrefix('!');
                $routeProvider.otherwise({redirectTo: '/Login'});
                $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
            }])
        
        .controller('ControladorLogout', ['$scope', '$rootScope', '$http', '$location', function ($scope, $rootScope, $http, $location) {
                $scope.logout = function () {
                    $http.post('/logout', {}).success(function () {
                        $rootScope.authenticated = false;
                        $location.path("/Login");
                        $rootScope.Cliente= false;
                        $rootScope.Professional= false;
                    }).error(function (data) {
                        $rootScope.authenticated = false;
                    });
                };
            }]);
    
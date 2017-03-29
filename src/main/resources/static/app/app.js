'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
    'ngRoute',
    'ngMaterial',
    'myApp.Inicio',
    'myApp.Cliente',
    'myApp.Login',
    'myApp.Servicios',
    'myApp.Reservas',
    'myApp.ServiciosDisponibles',
    'myApp.ServiciosSolicitados',
    'myApp.ServiciosSolicParaReservar',
    'myApp.version',
    'myApp.Professional',
    'myApp.Opciones',
    'myApp.Registrar',
    'myApp.Perfil',
    'myApp.Editar',
    'services.modulo'
]).
        config(['$locationProvider', '$routeProvider', '$httpProvider', function ($locationProvider, $routeProvider, $httpProvider) {
                $locationProvider.hashPrefix('!');
                $routeProvider.otherwise({redirectTo: '/Inicio'});
                $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
                localStorage.clear();
            }])
        
        .controller('ControladorLogout', ['$scope', '$rootScope', '$http', '$location', function ($scope, $rootScope, $http, $location) {
                $scope.logout = function () {
                    $http.post('/logout', {}).then(function () {
                        $rootScope.authenticated = false;
                        $location.path("/Login");
                        $rootScope.Cliente= false;
                        $rootScope.Professional= false;
                    }).then(function (data) {
                        $rootScope.authenticated = false;
                    });
                };
            }]);
    
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
    'services.modulo',
    'myApp.SolicitarNuevoServicio'
]).
        config(['$locationProvider', '$routeProvider', '$httpProvider', '$mdThemingProvider', function ($locationProvider, $routeProvider, $httpProvider, $mdThemingProvider) {
                $locationProvider.hashPrefix('!');
                $routeProvider.otherwise({redirectTo: '/Inicio'});
                $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
                localStorage.clear();

                $mdThemingProvider.definePalette('fondo', {
                                        '50': 'ffffff',
                                        '100': '5ed596',
                                        '200': '5ed596',
                                        '300': 'e57373',
                                        '400': 'ef5350',
                                        '500': 'f44336',
                                        '600': 'e53935',
                                        '700': 'd32f2f',
                                        '800': 'c62828',
                                        '900': 'b71c1c',
                                        'A100': 'ff8a80',
                                        'A200': 'ff5252',
                                        'A400': 'ff1744',
                                        'A700': 'd50000',
                                        'A69': 'ffe717',
                                        'error': 'ffe717',
                                        'contrastDefaultColor': 'light',    // whether, by default, text (contrast)
                                                                            // on this palette should be dark or light

                                        'contrastDarkColors': ['50', '100', //hues which contrast should be 'dark' by default
                                         '200', '300', '400', 'A100'],
                                        'contrastLightColors': undefined    // could also specify this if default was 'dark'
                                  });

                                $mdThemingProvider.theme('default')
                                    .primaryPalette('fondo')


            }])
        
        .controller('ControladorLogout', ['$scope', '$rootScope', '$http', '$location', 'professionalState', 'professionalStateUpdate', function ($scope, $rootScope, $http, $location, professionalState, professionalStateUpdate) {
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



                $scope.state = "Actualizar";
                $scope.fondo = "fondo-A69";
                $scope.startedState = false;
                $scope.status = 1;
                $scope.changeColor = function(){
                    if($scope.status === 1){
                        $scope.state = "Disponible";
                        $scope.fondo = "fondo-100";
                    }else if($scope.status === 0){
                        $scope.state = "No disponible";
                        $scope.fondo = "fondo-800";
                    }
                }

                $scope.changeStatus = function(){

                    var response = professionalState.get({email:$rootScope.UserID});

                    response.$promise.then(function(data) {

//                        console.log(data[0]);
                        $scope.status = data[0];

                        if($scope.startedState){
                            if(data[0] === 0) {
                                $scope.status = 1;
                            } else {
                                $scope.status = 0;
                            }
//                            console.log($scope.status);
                            var update = professionalStateUpdate.save([$scope.status + "", $rootScope.EmailString.email]);
                            update.$promise.then(function(data) {
                                $scope.changeColor();
                            });

                        } else {
                            $scope.changeColor();
                            $scope.startedState = true;
                        }

                        $scope.startedState = true;

                    });

                }
            }]);
    
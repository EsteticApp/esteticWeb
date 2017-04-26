 'use strict';

angular.module('myApp.Servicios', ['ngRoute'])

        .config(['$routeProvider','$mdThemingProvider', function ($routeProvider,$mdThemingProvider) {
                $routeProvider.when('/Servicios', {
                    templateUrl: 'Servicios/Servicios.html',
                    controller: 'ControladorServicios'
                });

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
                        'contrastDefaultColor': 'light',    // whether, by default, text (contrast)
                                                            // on this palette should be dark or light

                        'contrastDarkColors': ['50', '100', //hues which contrast should be 'dark' by default
                         '200', '300', '400', 'A100'],
                        'contrastLightColors': undefined    // could also specify this if default was 'dark'
                  });

                $mdThemingProvider.theme('default')
                    .primaryPalette('fondo')

            }])

        .controller('ControladorServicios', ['$scope', '$http', '$location', function ($scope, $http, $location) {

            $scope.sPeluqueria = function(){
                $location.path("/ServiciosDisponibles");
                localStorage.catSeleccionada = 1;
            };

            $scope.sUnas = function(){
                $location.path("/ServiciosDisponibles");
                localStorage.catSeleccionada = 2;
            };

            $scope.sDepilacion = function(){
                $location.path("/ServiciosDisponibles");
                localStorage.catSeleccionada = 3;
            };

            $scope.sMasajes = function(){
                $location.path("/ServiciosDisponibles");
                localStorage.catSeleccionada = 4;
            };

            $scope.peluqueria = [
                { name: 'Cepillado', wanted: false},
                { name: 'Cortes', wanted: false },
                { name: 'Tintes', wanted: false },
                { name: 'Mechas', wanted: false },
                { name: 'Mechas', wanted: false },
                { name: 'Extenciones', wanted: false },
                { name: 'Decoraciones', wanted: false },
                { name: 'Recogidos', wanted: false },
                { name: 'Torsades', wanted: false }
             ];

              $scope.unas = [
                 { name: 'Manicura', wanted: false},
                 { name: 'Pedicure', wanted: false },
                 { name: 'Esmaltado permanente', wanted: false },
                 { name: 'Unas esculpidas', wanted: false },
                 { name: 'Decoracion', wanted: false }
              ];

               $scope.depilacion = [
                  { name: 'Tradicional', wanted: false},
                  { name: 'Roll-on', wanted: false },
                  { name: 'Cera caliente', wanted: false },
                  { name: 'Egipcia', wanted: false }
               ];

                $scope.masajes = [
                   { name: 'Oriental con ventosas', wanted: false},
                   { name: 'Hot stones', wanted: false },
                   { name: 'Tuina', wanted: false },
                   { name: 'Tailandés', wanted: false },
                   { name: 'Circulatorio', wanted: false },
                   { name: 'Anticelulítico', wanted: false }
                ];

        }]);
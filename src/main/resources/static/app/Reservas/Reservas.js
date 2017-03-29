 'use strict';

angular.module('myApp.Reservas', ['ngRoute'])

        .config(['$routeProvider','$mdThemingProvider', function ($routeProvider,$mdThemingProvider) {
                $routeProvider.when('/Reservas', {
                    templateUrl: 'Reservas/Reservas.html',
                    controller: 'ControladorReservas'
                });

                $mdThemingProvider.definePalette('fondo', {
                        '50': 'ffffff',
                        '100': '5ed596',
                        '200': '337ab7',
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

        .controller('ControladorReservas', ['$scope', '$http', '$location', '$mdDialog','reservas','reservasUsers','$rootScope',function ($scope,$http, $location,$mdDialog,reservas,reservasUsers,$rootScope) {

             $scope.cancelar = function(ev) {
                console.log("cancelar servicio");
                var confirm = $mdDialog.confirm()
                      .title('¿Desea cancelar el servicio?')
                      .textContent('si el servicio es cancelado, se notificara al estilista')
                      .ariaLabel('Lucky day')
                      .targetEvent(ev)
                      .ok('Atras')
                      .cancel('Cancelar');

                $mdDialog.show(confirm).then(function() {
                  $scope.status = 'You decided to get rid of your debt.';
                }, function() {
                  $scope.status = 'You decided to keep your debt.';
                });
             };

            $scope.modificar = function(){
                console.log("modificar servicio");
            };

            $scope.detalles = function(){
                console.log("detalles servicio");
            };

            $scope.aceptar = function(ev) {
                console.log("Aceptar servicio");
                var confirm = $mdDialog.confirm()
                      .title('Desea aceptar el servicio?')
                      .textContent('si el servicio es aceptado, se notificara al cliente')
                      .ariaLabel('Lucky day')
                      .targetEvent(ev)
                      .ok('Aceptar')
                      .cancel('Cancelar');

                $mdDialog.show(confirm).then(function() {
                  $scope.status = 'You decided to get rid of your debt.';
                }, function() {
                  $scope.status = 'You decided to keep your debt.';
                });
             };

//             var tr = reservas.Reserva.query();
//             $scope.reservaCliente = tr;
               console.log($rootScope.EmailString);
               var tr = reservasUsers.Consultar($rootScope.EmailString);
               $scope.reservaCliente = tr;
        }]);

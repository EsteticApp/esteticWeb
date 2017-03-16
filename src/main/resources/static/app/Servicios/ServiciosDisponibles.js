'use strict';

angular.module('myApp.ServiciosDisponibles', ['ngRoute', 'ngMaterial'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/ServiciosDisponibles', {
                    templateUrl: 'Servicios/ServiciosDisponibles.html',
                    controller: 'ControladorServiciosDisponibles'
                });
            }])


        .controller('ControladorServiciosDisponibles', ['$scope', '$rootScope', '$http', '$location', 'estilistasCategorias', 'estCat', function ($scope, $rootScope, $http, $location, estilistasCategorias, estCat) {
                console.log("Categoria seleccionada primer paso : "+$rootScope.categoriaSeleccionada+" otra> "+ localStorage.catSeleccionada);
                estilistasCategorias.get(function (data) {
                    $scope.estilistas = data;
                })


//                $scope.professional = function () {
//                    console.log("Profesional");
//                    $location.path("/Professional");
//                }

                //$scope.estilistas = estCat.get({categoria:localStorage.getItem('categoria')});


            }])

        .controller('ListCtrl', function ($scope, $mdDialog, $location) {

            //$scope.estilistas = [
            // { name: 'Janet Perkins', img: "image/peluqueria.jpg", newMessage: true },
            //{ name: 'Mary Johnson', img: 'img/100-1.jpeg', newMessage: false },
            //{ name: 'Peter Carlsson', img: 'img/100-2.jpeg', newMessage: false }
            //];


            $scope.goToPerson = function (person, event) {

                /*$mdDialog.show(
                 $mdDialog.alert()
                 .title('Navigating')
                 .textContent('Inspect ' + person)
                 .ariaLabel('Person inspect demo')
                 .ok('Neat!')
                 .targetEvent(event)
                 );*/
            }
            $scope.goToPerson = function (estilista, event) {
                $mdDialog.show(
                        $mdDialog.confirm()
                        .title(estilista)
                        .textContent('Reserva ya tu servicio.')
                        .ariaLabel('Lucky day')
                        .ok('RESERVAR!')
                        .cancel('CANCELAR')
                        .targetEvent($location.path("/Servicios"))
                        );
            };
        });




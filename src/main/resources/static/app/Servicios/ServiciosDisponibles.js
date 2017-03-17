'use strict';

angular.module('myApp.ServiciosDisponibles', ['ngRoute', 'ngMaterial'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/ServiciosDisponibles', {
                    templateUrl: 'Servicios/ServiciosDisponibles.html',
                    controller: 'ControladorServiciosDisponibles'
                });
            }])


        .controller('ControladorServiciosDisponibles', ['$resource','$scope', '$rootScope', '$http', '$location', 'estilistasCategorias', 'estCat', function ($resource,$scope, $rootScope, $http, $location, estilistasCategorias, estCat) {                $scope.estilistas;
                $scope.catselect = localStorage.catSeleccionada;
                console.log("Selecciono categoria:"+$scope.catselect);
                $scope.pedir = function(){
                      console.log("solicitando categoria:"+$scope.catselect);
                      var esti = $resource('/estilistas/'+localStorage.catSeleccionada+'/:rolEstilista');
                      $scope.estilistas = esti.query();
                };
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




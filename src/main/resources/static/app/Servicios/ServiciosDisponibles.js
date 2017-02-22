'use strict';

angular.module('myApp.ServiciosDisponibles', ['ngRoute', 'ngMaterial'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/ServiciosDisponibles', {
                    templateUrl: 'Servicios/ServiciosDisponibles.html',
                    controller: 'ControladorServiciosDisponibles'
                });
            }])


        .controller('ControladorServiciosDisponibles', ['$scope', '$rootScope', '$http', '$location','estilistasCategorias','estCat',function ($scope, $rootScope, $http, $location,estilistasCategorias,estCat) {
               estilistasCategorias.get(function(data){
                       console.log(data[0]);
                       $scope.estilistas = data;
               })
<<<<<<< HEAD

               $scope.professional = function(){
                    console.log("Profesional");
                    $location.path("/Professional");
               }
=======
               //$scope.estilistas = estCat.get({categoria:localStorage.getItem('categoria')});
>>>>>>> 831223e323961512e4bc0de6f9a6ead117d35a9f

         }])

        .controller('ListCtrl', function($scope, $mdDialog,$location) {

          //$scope.estilistas = [
           // { name: 'Janet Perkins', img: "image/peluqueria.jpg", newMessage: true },
            //{ name: 'Mary Johnson', img: 'img/100-1.jpeg', newMessage: false },
            //{ name: 'Peter Carlsson', img: 'img/100-2.jpeg', newMessage: false }
          //];

<<<<<<< HEAD
          $scope.goToPerson = function(person, event) {

         /*$mdDialog.show(
              $mdDialog.alert()
                .title('Navigating')
                .textContent('Inspect ' + person)
                .ariaLabel('Person inspect demo')
                .ok('Neat!')
                .targetEvent(event)
            );*/
=======
          $scope.goToPerson = function(estilista, event) {
            $mdDialog.show(
              $mdDialog.confirm()
                .title(estilista)
                .textContent('Reserva ya tu servicio.')
                .ariaLabel('Lucky day')
                .ok('RESERVAR!')
                .cancel('CANCELAR')
                .targetEvent( $location.path("/Servicios"))
            );
>>>>>>> 831223e323961512e4bc0de6f9a6ead117d35a9f
          };


        });




'use strict';

angular.module('myApp.ServiciosDisponibles', ['ngRoute', 'ngMaterial'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/ServiciosDisponibles', {
                    templateUrl: 'Servicios/ServiciosDisponibles.html',
                    controller: 'ControladorServiciosDisponibles'
                });
            }])


        .controller('ControladorServiciosDisponibles', ['$scope', '$rootScope', '$http', '$location','estilistasCategorias',function ($scope, $rootScope, $http, $location,estilistasCategorias) {
               estilistasCategorias.get(function(data){
                       $scope.estilistas = data;
               })
         }])

        .controller('ListCtrl', function($scope, $mdDialog) {

          //$scope.estilistas = [
           // { name: 'Janet Perkins', img: "image/peluqueria.jpg", newMessage: true },
            //{ name: 'Mary Johnson', img: 'img/100-1.jpeg', newMessage: false },
            //{ name: 'Peter Carlsson', img: 'img/100-2.jpeg', newMessage: false }
          //];

          $scope.goToPerson = function(person, event) {
            $mdDialog.show(
              $mdDialog.alert()
                .title('Navigating')
                .textContent('Inspect ' + person)
                .ariaLabel('Person inspect demo')
                .ok('Neat!')
                .targetEvent(event)
            );
          };
        });




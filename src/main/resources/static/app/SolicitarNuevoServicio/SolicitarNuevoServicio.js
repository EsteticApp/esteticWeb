'use strict';

angular.module('myApp.SolicitarNuevoServicio', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/SolicitarNuevoServicio', {
                    templateUrl: 'SolicitarNuevoServicio/SolicitarNuevoServicio.html',
                    controller: 'ControladorSolicitarNuevoServicio'
                });
            }])

        
        .controller('ControladorSolicitarNuevoServicio', ['$scope', function ($scope) {
                $scope.newServiceName;
                $scope.newServiceDescription;
                $scope.requestNewService = function(){
                    var body = "Tu solicitud ha sido enviada \n Servicio: " + $scope.newServiceName + "\n " + "Descripción: " + $scope.newServiceDescription;
                    var body2 = "Por favor considera este nuevo servicio \n Servicio: " + $scope.newServiceName + "\n " + "Descripción: " + $scope.newServiceDescription;
                    window.location.href('mailto:Skist1975@armyspy.com?subject=Solicitud nuevo servicio&body='+body2);
                    alert(body);
                }

        }]);

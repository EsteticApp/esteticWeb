'use strict';

angular.module('myApp.Registrar', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/Registrar', {
                    templateUrl: 'Registrar/Registrar.html',
                    controller: 'ControladorRegistrar'
                });
            }])


        .controller('ControladorRegistrar', ['$scope', '$rootScope', 'registrarService', '$location', function ($scope, $rootScope, registrarService, $location) {
                $scope.status = "working";

                $scope.test = function () {
                    console.log('testing....');
                }

                $scope.uploadFile = function () {
                    var file = $scope.myFile;
                    console.log('file is ');
                    console.dir(file);
                    $scope.EmailString={}
                    $scope.EmailString.email=$rootScope.users.email;
                    var uploadUrl = "./user/imagen/upload?email=" + $rootScope.EmailString;
                    fileUpload.uploadFileToUrl(file, uploadUrl);
                };



                $scope.RegistrarUsu = function () {
                    registrarService.Registrar($rootScope.users);
                    $scope.uploadFile();
                    console.log($rootScope.users)
                    $rootScope.value = true;
                    $location.path("/Login");
                }
            }]);
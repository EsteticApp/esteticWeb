'use strict';

angular.module('myApp.Registrar', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/Registrar', {
                    templateUrl: 'Registrar/Registrar.html',
                    controller: 'ControladorRegistrar'
                });
            }])

        .service('fileUpload', ['$http', function ($http) {
                this.uploadFileToUrl = function (file, uploadUrl,StringEmail) {
                    var fd = new FormData();
                    fd.append('file', file);
                    StringEmail.request=fd;
                    console.log("Archivo " + fd);
                    $http.post(uploadUrl,fd,{
//                        params:{request: fd, email: StringEmail},
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
                    })
                            .then(function () {
                            })
                            .catch(function () {
                            });
                }
            }])

        .directive('fileModel', ['$parse', function ($parse) {
                return {
                    restrict: 'A',
                    link: function (scope, element, attrs) {
                        var model = $parse(attrs.fileModel);
                        var modelSetter = model.assign;
                        console.log("entra aca")
                        element.bind('change', function () {
                            scope.$apply(function () {
                                modelSetter(scope, element[0].files[0]);
                            });
                        });
                    }
                };
            }])

        .controller('ControladorRegistrar', ['$scope', '$rootScope', 'registrarService', 'fileUpload', '$q','$location', function ($scope, $rootScope, registrarService, fileUpload, $q,$location) {

                $scope.test = function () {
                    console.log('testing....');
                }

                $scope.uploadFile = function () { 
                    var file = $scope.photo;
                    //console.log(file);
                    console.log('file is ');
                    console.dir(file);
                    
                    $scope.EmailString = {}
                    $scope.EmailString.email = $rootScope.users.email;
                    console.log($scope.EmailString.email);
                    var uploadUrl = "./user/image/upload?email="+$scope.EmailString.email;
//                    var uploadUrl = "/Usuario/upload";
//                    console.log(file)
                    fileUpload.uploadFileToUrl(file, uploadUrl,$scope.EmailString);
                   
                };


                $scope.llamaruno=function (){
                        console.log("perimero")
                        registrarService.Registrar($rootScope.users);
                        var defered = $q.defer();  
                        var promise = defered.promise;
                        return promise;
                    };

                $scope.RegistrarUsu = function () {
                    var promise=$scope.llamaruno();
                    promise.then(function(){
                        console.log("despues")
                        $scope.uploadFile();
                    });
                   
                    //console.log($rootScope.users);
                    
                    //console.log($rootScope.users);
                    $scope.uploadFile();
                    console.log($rootScope.users)
                    $rootScope.value = true;
                    $location.path("/Login");
                }
            }]);
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
                    var fds={}
                    var fd = new FormData();
                    fd.append('file', file);
                    fds.request=fd;
                    fds.email=StringEmail;
//                    System.out.println("Archivo " + file);
                    $http.post(uploadUrl,fds,{ 
//                        params:{request: fd, email: StringEmail},
                        transformRequest: angular.identity,
                        headers: {'Content-Type': undefined}
                    })
                            .success(function () {
                            })
                            .error(function () {
                            });
                }
            }])

        .directive('fileModel', ['$parse', function ($parse) {
                return {
                    restrict: 'A',
                    link: function (scope, element, attrs) {
                        var model = $parse(attrs.fileModel);
                        var modelSetter = model.assign;

                        element.bind('change', function () {
                            scope.$apply(function () {
                                modelSetter(scope, element[0].files[0]);
                            });
                        });
                    }
                };
            }])

        .controller('ControladorRegistrar', ['$scope', '$rootScope', 'registrarService', 'fileUpload', '$location', function ($scope, $rootScope, registrarService, fileUpload, $location) {
                $scope.status = "working";

                $scope.test = function () {
                    console.log('testing....');
                }

                $scope.uploadFile = function () { 
                     registrarService.Registrar($rootScope.users);
                    var file = $rootScope.photo;
                    //console.log(file);
                    console.log('file is ');
                    console.dir(file);
                    $scope.EmailString = {}
                    $scope.EmailString.email = $rootScope.users.email;
                    console.log($scope.EmailString.email);
                    var uploadUrl = "./user/image/upload";
//                    var uploadUrl = "/Usuario/upload";
//                    console.log(file)
                    fileUpload.uploadFileToUrl(file, uploadUrl);
                   
                };



                $scope.RegistrarUsu = function () {
                    //console.log($rootScope.users);
                    
                    //console.log($rootScope.users);
                    $scope.uploadFile();
                    console.log($rootScope.users)
                    $rootScope.value = true;
                    $location.path("/Login");
                }
            }]);
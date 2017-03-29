'use strict';

angular.module('myApp.Editar', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/Editar', {
                    templateUrl: 'Editar/Editar.html',
                    controller: 'ControladorEditar'
                });
            }])

          .service('fileUpload', ['$http', function ($http) {
                this.uploadFileToUrl = function (file, uploadUrl) {
                    var fd = new FormData();
                    fd.append('file', file);
                    console.log("Archivo " + fd);
                    $http.post(uploadUrl,fd,{
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
        .controller('ControladorEditar', ['$scope', '$rootScope', '$http', 'fileUpload','$location', 'usuarioPost','registrarUpdate', function ($scope, $rootScope, $http,fileUpload, $location,usuarioPost,registrarUpdate) {
                console.log($rootScope.EmailString);
                $scope.user = usuarioPost.Usuario($rootScope.EmailString);
                console.log($scope.user);
                
                $scope.test = function () {
                    console.log('testing....');
                }
                
                $scope.updateUser= function(){
                    registrarUpdate.Registrar($scope.user);
                    $location.path("/Perfil");
                }
                
                $scope.uploadFile = function () { 
                    var file = $scope.photo;
                    console.log('file is ');
                    console.dir(file);
                    $scope.EmailString = {}
                    $scope.EmailString.email = $scope.user.email;
                    console.log($scope.EmailString.email);
                    var uploadUrl = "./user/image/upload?email="+$scope.EmailString.email;
                    fileUpload.uploadFileToUrl(file, uploadUrl);
                   
                };

            }
        ]);

'use strict';

angular.module('myApp.Editar', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/Editar', {
                    templateUrl: 'Editar/Editar.html',
                    controller: 'ControladorEditar'
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

        .controller('ControladorEditar', ['$scope', '$rootScope', '$http', '$location', 'usuarioPost', function ($scope, $rootScope, $http, $location,usuarioPost) {
                console.log($rootScope.EmailString);
                $scope.user = usuarioPost.Usuario($rootScope.EmailString);
                console.log($scope.user);
            }
        ]);

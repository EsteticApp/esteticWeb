'use strict';

angular.module('myApp.Login', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/Login', {
                    templateUrl: 'Login/Login.html',
                    controller: 'ControladorLogin'
                });
            }])


        .controller('ControladorLogin', ['$scope', '$rootScope', '$http', '$location', function ($scope, $rootScope, $http, $location) {
                $scope.aut = false;
                $scope.person = [];
                var authenticate = function (credentials, callback) {
                    var headers = credentials ? {authorization: "Basic "
                                + btoa(credentials.username + ":" + credentials.password)
                    } : {};
                    
                    $http.get('user', {headers: headers}).then(successCallback, errorCallback);
                    function successCallback(data) {
                        console.log("entra");
                        console.log(data.data);
                        console.log(data.data.name);
                        if (data.data.name) {
                            $rootScope.authenticated = true;
                            console.log("pasooooooooo");
                              
                            $rootScope.Cliente= true;
                        } else {
                            $rootScope.Cliente= false;
                            $rootScope.authenticated = false;
                            console.log("No pasoooooooo");
                        }
                        callback && callback();
                    }
                    function errorCallback(error) {
                        console.log("error");
                        $rootScope.authenticated = false;
                        callback && callback();
                    }
                };

                authenticate();
                $scope.credentials = {};
                
                $scope.login = function () {
                    console.log("hace algo")
                    console.log($scope.credentials)
                    authenticate($scope.credentials, function () {
                        if ($rootScope.authenticated) {
                            $location.path("/Cliente");
                            $scope.error = false;
                            $rootScope.user=$scope.credentials.username;
                            
                        } else {
                            $location.path("/login");
                            $scope.error = true;
                        }
                        console.log("PAsa por aca")
                    });
                };
            }
        ]);
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
                        console.log(data.data);
                        console.log(data.data.name);
                        if (data.data.name) {
                            $rootScope.authenticated = true;
                            $scope.role=data.data.authorities[0].authority;
                            $rootScope.Cliente= $scope.role==="CLIENTE";
                            $rootScope.Professional= $scope.role==="PROFESSIONAL";
                            console.log($scope.role);
                            console.log($rootScope.Professional);
                            console.log($rootScope.Cliente);
                        } else {
                            $rootScope.Cliente= false;
                            $rootScope.Professional= false;
                            $rootScope.authenticated = false;
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
                $scope.role="";
                $scope.login = function () {
                    $rootScope.value = false;
                    console.log("hace algo")
                    console.log($scope.credentials)
                    authenticate($scope.credentials, function () {
                        if ($rootScope.authenticated) {
                            $location.path();
                            $scope.error = false;
                            $rootScope.user=$scope.credentials.username;
                            console.log($scope.role)
                            $location.path("/"+$scope.role);
                        } else {
                            $location.path("/login");
                            $scope.error = true;
                        }
                        console.log("Pasa por aca")
                    });
                };
            }
        ]);
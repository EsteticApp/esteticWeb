'use strict';

angular.module('myApp.Login', ['ngRoute','services.modulo'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/Login', {
                    templateUrl: 'Login/Login.html',
                    controller: 'ControladorLogin'
                });
            }])


        .controller('ControladorLogin', ['$scope', '$rootScope', '$http', '$location', 'userID', function ($scope, $rootScope, $http, $location, userID) {
                $scope.aut = false;
                $scope.person = [];
                $rootScope.EmailString={}

                $scope.getUserID = function(){

                    var response = userID.get({email:$rootScope.EmailString.email});

                    response.$promise.then(function(data) {
                        $rootScope.UserID = data[0];
                    });

                }
                var authenticate = function (credentials, callback) {
                    var headers = credentials ? {authorization: "Basic "
                                + btoa(credentials.username + ":" + credentials.password)
                    } : {};
                    
                    $http.get('user/auteticacion', {headers: headers}).then(successCallback, errorCallback);
                    function successCallback(data) {
                        if (data.data.name) {
                            $rootScope.EmailString.email=data.data.name;
                            $rootScope.authenticated = true;
                            $scope.role=data.data.authorities[0].authority;
                            $rootScope.Cliente= $scope.role==="CLIENT";
                            $rootScope.Professional= $scope.role==="PROFESSIONAL";
                        } else {
                            $rootScope.Cliente= false;
                            $rootScope.Professional= false;
                            $rootScope.authenticated = false;
                        }
                        callback && callback();
                    }
                    function errorCallback(error) {
                        $rootScope.authenticated = false;
                        callback && callback();
                    }
                };

                authenticate();
                $scope.credentials = {};
                $scope.role="";
                $scope.login = function () {
                    $rootScope.value = false;
                    authenticate($scope.credentials, function () {
                        if ($rootScope.authenticated) {
                            $location.path();
                            $scope.error = false;
                            $rootScope.user=$scope.credentials.username;
                            $location.path("/"+$scope.role);
                            $scope.getUserID();
                        } else {
                            $location.path("/login");
                            $scope.error = true;
                        }
                    });
                };
            }
        ]);
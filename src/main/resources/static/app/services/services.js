'use strict';

// Declare app level module which depends on views, and components
angular.module('services.modulo', ['ngRoute', 'ngResource'])

        .factory('categoria', function($resource){
            return $resource('/categorias',{},{
                GET: { method: 'GET', isArray: true}
            });

        })

        .factory('servicio', function($resource){
            return $resource('/servicios',{},{
                GET: { method: 'GET', isArray: true}
            });

        })

        .factory('estilista', function($resource){
            return $resource('/estilistas',{},{
                GET: { method: 'GET', isArray: true}
            });

        })

        .factory('estilistasCategorias', function($resource){
                    var categoria = localStorage.getItem('categoria');
                    console.log('LA CATEGORIA ES <<<>>>>'+categoria);
                    return $resource('/estilistas/'+categoria+'/:rolEstilista',{},{
                        get: {
                            method: 'GET',
                            isArray: true
                        }
                    });

             })

        .factory('registrarService', function($resource){
            return $resource('./Registrar',
            {nombre:'@nombre',cedula:'@cedula',mail:'@mail',password:'@password',role:'@role'},{
                Registrar: { method: 'POST'}
            });
        })

        .factory('estCat',function($resource){
            return $resource('/estilistas/: categorias',{},{
                          get: {
                              method: 'GET',
                              isArray: true
                          }
                      });
        })
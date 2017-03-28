'use strict';

// Declare app level module which depends on views, and components
angular.module('services.modulo', ['ngRoute', 'ngResource'])


        .factory('usuario', function($resource){
            return $resource('./user/email/',{email:"@email"},{
                GET: { method: 'GET'}
            });

        })
        
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
                    var esti = $resource('/estilistas/'+localStorage.catSeleccionada+'/:rolEstilista');
                    return esti;
         })

        .factory('registrarService', function($resource){
            return $resource('./user/Registrar',
            {name:"@name",idCard:"@idCard",password:"@password",email:"@mail",Roles_idRole:{idRole:"@idRole",nombre:"@nombre"},photo:"@photo",state:"@state"},{
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
        });
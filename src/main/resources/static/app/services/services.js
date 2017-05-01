'use strict';

// Declare app level module which depends on views, and components
angular.module('services.modulo', ['ngRoute', 'ngResource'])


        .factory('usuarioPost', function($resource){
            
            return $resource('./user/email',
            {email:"@email"},{
                Usuario: { method: 'POST'}
            });
        })
        
        .factory('usuarioPhoto', function($resource){
            return $resource('./user/:email/image',
            {},{
                Usuario: { method: 'GET'}
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

        .factory('reservas', function($resource){
            return {
                 Reserva: $resource('/reservas/:id', {id: '@id'})
            };
        })

        .factory('reservasUsers', function($resource){
            console.log("consultando reservas users")
            return $resource('/reservas/email',
            {id:"@id"},{
                Consultar: { method: 'POST'}
            });
         })


        .factory('estilista', function($resource){
            return $resource('/estilistas',{},{
                GET: { method: 'GET', isArray: true}
            });

        })

        .factory('precios', function($resource){
            return {
                 Precios: $resource('/precios/:id', {id: '@id'})
            };
        })

        .factory('preciosServicios', function($resource){
            console.log("Muestra precios por id de servicios")
            var precio = $resource('/reservas/'+ localStorage.servicioSeleccionado +'/:price');
            return precio;

        })



        .factory('estilistasCategorias', function($resource){
                    var esti = $resource('/estilistas/'+localStorage.catSeleccionada+'/:rolEstilista');
                    return esti;
         })

        .factory('registrarService', function($resource){
             
             return $resource('./user/Registrar',{},{
            //{name:"@name",idCard:"@idCard",password:"@password",email:"@mail",roles:"@idRole",photo:"@photo",state:"@state"},{
                Registrar: { method: 'POST'}
            });
            
        })
        
        .factory('registrarUpdate', function($resource){
             
             return $resource('./user/Update',
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
        })

        .factory('professionalState',function($resource){
            return $resource('/estilistas/:email/state', {}, {
                get:        {method: 'GET',
                             isArray: true},
                save:     {method: 'POST'}
            });
        })

        .factory('professionalStateUpdate',function($resource){
            return $resource('/estilistas/update/state', {}, {
                save:     {method: 'POST'}
            });
        });

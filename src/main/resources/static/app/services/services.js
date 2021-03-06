'use strict';

// Declare app level module which depends on views, and components
angular.module('services.modulo', ['ngRoute', 'ngResource'])


        .factory('usuarioPost', function($resource){
            
            return $resource('./user/email',
            {},{
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

        .factory('reservasUsers',function($resource){
            return $resource('/reservas/reserva/cliente/:clientID', {}, {
                get:        {method: 'GET',
                             isArray: true}
            });
        })

        .factory('reservasProfesional',function($resource){
            return $resource('./reservas/reserva/professional/:professionalID', {}, {
                get:        {method: 'GET',
                             isArray: true}
            });
        })

//        .factory('reservasUsers', function($resource){
//            console.log("consultando reservas users")
//            return $resource('/reservas/email',
//            {id:"@id"},{
//                Consultar: { method: 'POST'}
//            });
//         })


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

        .factory('estilistasServicios',function($resource){
            var servicio = $resource('/estilistas/id/'+localStorage.estilista);
            return servicio;
        })


        .factory('professionalState',function($resource){
            return $resource('/estilistas/estilista/state/:id', {}, {
                get:        {method: 'GET',
                             isArray: true},
                save:     {method: 'POST'}
            });
        })

        .factory('professionalStateUpdate',function($resource){
            return $resource('/estilistas/estilista/state', {}, {
                save:     {method: 'POST'}
            });
        })

        .factory('userID',function($resource){
            return $resource('/app/user/id/:email', {}, {
                get:        {method: 'GET',
                             isArray: true}
            });
        });

'use strict';

describe('myApp.Cliente module', function() {

  beforeEach(module('myApp.Cliente'));

  describe('Cliente controller', function(){

    it('should ....', inject(function($controller) {
      //spec body
      var loginCtrl = $controller('ControladorCliente');
      expect(loginCtrl).toBeDefined();
    }));

  });
});
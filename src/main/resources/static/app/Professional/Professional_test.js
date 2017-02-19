'use strict';

describe('myApp.Professional module', function() {

  beforeEach(module('myApp.Professional'));

  describe('Professional controller', function(){

    it('should ....', inject(function($controller) {
      //spec body
      var loginCtrl = $controller('ControladorProfessional');
      expect(loginCtrl).toBeDefined();
    }));

  });
});
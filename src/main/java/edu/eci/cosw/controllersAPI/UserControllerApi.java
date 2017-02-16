/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.controllersAPI;

import java.security.Principal;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author 2101240
 */
public class UserControllerApi {
    @RequestMapping("/app/user")
    public Principal user(Principal user) {
        System.out.println("Entra por aca");
        System.out.println(user);
        return user;
    }       
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.models;

import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 *
 * @author estudiante
 */
public class ImageEmailString {
    private MultipartHttpServletRequest request;
    private EmailString email;

    public ImageEmailString() {
    }

    public MultipartHttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(MultipartHttpServletRequest request) {
        this.request = request;
    }

    public EmailString getEmail() {
        return email;
    }

    public void setEmail(EmailString email) {
        this.email = email;
    }
    
}

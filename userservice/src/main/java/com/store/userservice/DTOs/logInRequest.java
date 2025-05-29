package com.store.userservice.DTOs;


import jakarta.persistence.Column;


public class logInRequest {

    @Column(unique = true, nullable = false )
    private String email;
    @Column( nullable = false )
    private String password;


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


    
}

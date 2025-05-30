package com.store.orderservice.DTOs;

import jakarta.persistence.Column;


public class UserDTO {
    
      private int id;

    @Column(name = "username")
    private String name;
    private String email;
    private String password;


   

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

     public void setId(int id){
        this.id=id;
    }
   
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

  
}

package com.store.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.store.userservice.DTOs.UserDTO;
import com.store.userservice.DTOs.logInRequest;
import com.store.userservice.DTOs.signUpRequest;
import com.store.userservice.service.Userservice;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {
     
   @Autowired private Userservice userService; 

     @GetMapping("/{userid}")
     public ResponseEntity<UserDTO> getUserprofile(@PathVariable("userid") Integer id) {
         return ResponseEntity.ok(userService.getUserprofile(id));
     }
     
      @PostMapping("/signUp")
     public ResponseEntity<UserDTO> signUp(@Valid @RequestBody signUpRequest request) {
         return ResponseEntity.ok(userService.signUp(request));
     }

     @PostMapping("/logIn")
     public ResponseEntity<UserDTO> logIn(@Valid @RequestBody logInRequest request) {
         
         return ResponseEntity.ok(userService.logIn(request));
     }
     
     
}

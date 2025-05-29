package com.store.orderservice.Clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.store.orderservice.DTOs.UserDTO;

@FeignClient(name = "USER-SERVICE")

public interface UserClient {
     @GetMapping("/api/users/{id}")
     UserDTO getUserprofile(@PathVariable("id") int id);
}

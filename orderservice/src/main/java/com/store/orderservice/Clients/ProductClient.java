package com.store.orderservice.Clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.store.orderservice.DTOs.ProductDTO;

@FeignClient(name = "PRODUCT-SERVICE")

public interface ProductClient {
     @GetMapping("/getByIds")
  public List<ProductDTO> getProductsByIds(@RequestParam List<Integer> ids);
  @GetMapping("/getTotalPrice")
  public ResponseEntity<Double> getTotalPrice(@RequestParam List<Integer> ids);
  
}

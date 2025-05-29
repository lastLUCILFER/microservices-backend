package com.store.productservice.controller;

import org.springframework.web.bind.annotation.*;

import com.store.productservice.DTOs.ProductDTO;
import com.store.productservice.DTOs.ProductRequest;
import com.store.productservice.service.Productservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("api/products")
@CrossOrigin
public class ProductController {
     @Autowired private Productservice productservice;

    @PostMapping("/addProduct")
    public ResponseEntity<ProductDTO> AddPorudct(@RequestBody ProductRequest request) {
      return ResponseEntity.ok(productservice.AddRequest(request));
    }


    @PutMapping("/updatePorduct/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable int id, @RequestBody ProductRequest request){
      return ResponseEntity.ok(productservice.updateProduct(id,request));
    }

    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable int id){
      productservice.deleteProduct(id);
    }
    
    @GetMapping("/productDetails/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable int id) {
        return ResponseEntity.ok(productservice.getProduct(id));
    }
    
    @GetMapping("/showAll")
    public List<ProductDTO> getAllProducts() {
        return productservice.getAllProducts();
    }
    @GetMapping("/getByIds")
    public List<ProductDTO> getProductsByIds(@RequestParam List<Integer> ids) {
    return productservice.getProductsByIds(ids);
  }
  @GetMapping("/getTotalPrice")
  public ResponseEntity<Double> getTotalPrice(@RequestParam List<Integer> ids) {
    double total = productservice.getTotalPrice(ids);
    return ResponseEntity.ok(total);
}

  
}

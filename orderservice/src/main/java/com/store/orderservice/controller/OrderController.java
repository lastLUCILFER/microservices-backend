package com.store.orderservice.controller;

import com.store.orderservice.DTOs.OrderDTO;
import com.store.orderservice.DTOs.OrderRequest;
import com.store.orderservice.service.Orderservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;





@RestController
@RequestMapping("/api/orders")
@CrossOrigin
public class OrderController {

    @Autowired
    private Orderservice orderservice;

 
    @PostMapping("/track")
    public ResponseEntity<OrderDTO> trackOrder(
            @RequestBody OrderRequest request,
            @RequestParam List<Integer> productIds) {
        return ResponseEntity.ok(orderservice.trackOrder(request, productIds));
    }


    @GetMapping
    public ResponseEntity<List<OrderDTO>> getUserOrders(@RequestHeader("x-User-Id") int user_id)
    {
        return ResponseEntity.ok(orderservice.getUserOrders(user_id));
    }


    @GetMapping("/{orderid}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable  int orderid)
    {
        return ResponseEntity.ok(orderservice.getOrderById(orderid));
    }
}

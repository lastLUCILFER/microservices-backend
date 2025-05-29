package com.store.paymentservice.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.store.paymentservice.DTOs.PaymentDTO;
import com.store.paymentservice.DTOs.paymentRequest;
import com.store.paymentservice.service.Paymentservice;


@RestController
@RequestMapping("/api/payments")
@CrossOrigin
public class PaymentController {
       @Autowired private Paymentservice paymentservice;


    @PostMapping
    public ResponseEntity<PaymentDTO> trackPayment(@RequestBody paymentRequest request){
        return ResponseEntity.ok(paymentservice.trackPayment(request));
    }

  
     @GetMapping("/{paymentid}")
    public ResponseEntity<PaymentDTO> getPaymentById(@PathVariable  int paymentid)
    {
        return ResponseEntity.ok(paymentservice.getPaymentById(paymentid));
    }


     @GetMapping("/validate/{paymentId}")
    public String validatePayment(@PathVariable int paymentId) {
        return paymentservice.validatePayment(paymentId);
    }
}

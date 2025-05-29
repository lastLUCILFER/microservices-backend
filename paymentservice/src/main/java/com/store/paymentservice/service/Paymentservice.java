package com.store.paymentservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.paymentservice.DTOs.PaymentDTO;
import com.store.paymentservice.DTOs.paymentRequest;
import com.store.paymentservice.Entity.Payment;
import com.store.paymentservice.repository.PaymentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Paymentservice {
         @Autowired private final PaymentRepository paymentRepository;


public PaymentDTO trackPayment(paymentRequest request){
    Payment payment = Payment.builder()
                        .order_id(request.getOrder_id())
                        .methode(request.getMethode())
                        .build();
    Payment savedPayment = paymentRepository.save(payment);
    return mapPaymentDTO(savedPayment);
}



public PaymentDTO getPaymentById(int paymentid){
    return paymentRepository.findById(paymentid).map(this::mapPaymentDTO)
            .orElseThrow(() -> new RuntimeException("payment not found with id "+ paymentid));
}



       public String validatePayment(int paymentId) {
        Payment payment = paymentRepository.findById(paymentId)
            .orElseThrow(() -> new RuntimeException("Payment not found"));

        return "Payment with ID " + payment.getId() + " is validated at " + payment.getDate_payment();
    }


 
    public PaymentDTO mapPaymentDTO(Payment payment){
        PaymentDTO dto =new PaymentDTO();
        dto.setId(payment.getId());
        dto.setOrder_id(payment.getOrder_id());
        dto.setMethode(payment.getMethode());
        dto.setDate_payment(payment.getDate_payment());

        return dto;
    }
}

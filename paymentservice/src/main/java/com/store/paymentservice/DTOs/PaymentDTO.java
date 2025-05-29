package com.store.paymentservice.DTOs;

import java.time.LocalDateTime;

import com.store.paymentservice.Entity.PaymentMethode;

import lombok.Data;

@Data
public class PaymentDTO {

     private int id;

    private int order_id;
    private PaymentMethode methode;

    private LocalDateTime date_payment;

}

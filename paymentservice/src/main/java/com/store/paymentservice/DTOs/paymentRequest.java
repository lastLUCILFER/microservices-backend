package com.store.paymentservice.DTOs;



import com.store.paymentservice.Entity.PaymentMethode;

import lombok.Data;

@Data
public class paymentRequest {


    private int order_id;
    private PaymentMethode methode;

}

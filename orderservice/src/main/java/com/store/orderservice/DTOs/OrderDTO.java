package com.store.orderservice.DTOs;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class OrderDTO {


    private int idorder;


    @Column(name = "user_id")
    private int userId;

  
    @CreationTimestamp
    private LocalDateTime order_date;
    
    private double total;


 
}

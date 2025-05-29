package com.store.orderservice.DTOs;



import jakarta.persistence.Column;
import lombok.Data;
@Data
public class OrderRequest {
    
    

    @Column(name = "user_id")
    private int userId;
    private double total;
   
}

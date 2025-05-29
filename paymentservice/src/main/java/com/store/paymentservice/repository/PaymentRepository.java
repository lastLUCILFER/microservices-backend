package com.store.paymentservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.store.paymentservice.Entity.Payment;


public interface PaymentRepository extends JpaRepository<Payment,Integer>{
   

}

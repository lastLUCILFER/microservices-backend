package com.store.orderservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.orderservice.Entity.Order;

public interface OrderRepository extends JpaRepository<Order,Integer>{
    List<Order> findByUserId(int userId);

}


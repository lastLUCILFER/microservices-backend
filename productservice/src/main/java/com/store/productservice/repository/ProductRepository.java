package com.store.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.productservice.Entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{
        boolean existsByName(String name);
}

package com.store.userservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.userservice.Entity.User;

public interface UserRepository extends JpaRepository<User ,Integer> {
     boolean existsByEmail(String Email);
    Optional<User>  findByEmail(String email);

}

package com.Ecommerce.Signnup.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce.Signnup.Entity.User;

public interface UserRepo extends JpaRepository<User, Long>{

    Optional<User> findByEmailAndPassword(String email, String password); //Sign-in
    
} 
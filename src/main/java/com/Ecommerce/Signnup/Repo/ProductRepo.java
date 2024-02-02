package com.Ecommerce.Signnup.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Ecommerce.Signnup.Entity.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    
}

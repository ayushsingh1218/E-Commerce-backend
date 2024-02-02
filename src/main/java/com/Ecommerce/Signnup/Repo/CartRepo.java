package com.Ecommerce.Signnup.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Ecommerce.Signnup.Entity.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart, Long> {

    List<Cart> findByUserId(Long userId);

}

package com.Ecommerce.Signnup.Repo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce.Signnup.Entity.Billing;


public interface BillingRepo extends JpaRepository<Billing, Long> {
    // You can define custom query methods if needed
}


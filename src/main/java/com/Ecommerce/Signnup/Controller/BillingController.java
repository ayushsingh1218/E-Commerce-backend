package com.Ecommerce.Signnup.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.Signnup.Service.BillingService;

@RestController
@RequestMapping("/api/billing")
public class BillingController {

    @Autowired
    private BillingService billingService;

    @GetMapping("/total/{userId}")
    public ResponseEntity<Double> getTotalPriceForUser(@PathVariable Long userId) {
        double totalPrice = billingService.calculateTotalPrice(userId);
        return ResponseEntity.ok(totalPrice);
    }
}

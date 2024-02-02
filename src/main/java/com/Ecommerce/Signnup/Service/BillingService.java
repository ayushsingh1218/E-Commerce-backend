package com.Ecommerce.Signnup.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.Signnup.Entity.Cart;
import com.Ecommerce.Signnup.Entity.Product;
import com.Ecommerce.Signnup.Entity.User;

@Service
public class BillingService {
    

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;


    
    public double calculateTotalPrice(Long userId) {
        User user = userService.getUserById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        Cart[] cartItems = cartService.getCartItemsByUserId(userId);
        double totalPrice = 0;

        for (Cart cartItem : cartItems) {
            Product product = productService.getProductById(cartItem.getProduct().getId());
            totalPrice += product.getPrice() * cartItem.getQuantity();
        }

        return totalPrice;
    }

}


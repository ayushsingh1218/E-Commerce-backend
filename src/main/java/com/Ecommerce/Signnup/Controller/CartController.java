package com.Ecommerce.Signnup.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import java.lang.Long;

import com.Ecommerce.Signnup.Entity.Cart;
import com.Ecommerce.Signnup.Service.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private CartService cartService;

  
    @PostMapping("/add/{userId}/{pid}/{qty}")
    public ResponseEntity<Void> addToCart(  @PathVariable Long userId,@PathVariable Long pid,@PathVariable Integer qty ) {
        cartService.addToCart(userId,pid,qty);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

     @GetMapping("/all")
    public ResponseEntity<List<Cart>> getAllCartItems() {
        List<Cart> cartItems = cartService.getAllCartItems();
        return new ResponseEntity<>(cartItems, HttpStatus.OK);
    }

}
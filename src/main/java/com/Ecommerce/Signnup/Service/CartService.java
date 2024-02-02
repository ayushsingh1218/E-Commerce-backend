package com.Ecommerce.Signnup.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.Signnup.Entity.Cart;
import com.Ecommerce.Signnup.Entity.Product;
import com.Ecommerce.Signnup.Entity.User;
import com.Ecommerce.Signnup.Repo.CartRepo;
import com.Ecommerce.Signnup.Repo.ProductRepo;
import com.Ecommerce.Signnup.Repo.UserRepo;

@Service
public class CartService {
    

    @Autowired
    private CartRepo cartRepo;

    @Autowired 
    private ProductRepo productRepo;


    @Autowired
    private UserRepo userRepo;

    public void addToCart(Long userId,Long productId, Integer quantity) {
        // Retrieve the product by its ID
        Product product = productRepo.findById(productId)
            .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));
    
            User user = userRepo.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));    
        // Create a new Cart item
        Cart cartItem = new Cart();
        
        // Set the product and quantity
        cartItem.setUser(user);
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);
    
        // Save the cart item
        cartRepo.save(cartItem);
    }
    public List<Cart> getAllCartItems() {
        return cartRepo.findAll();
    }
    public Cart[] getCartItemsByUserId(Long userId) {
        List<Cart> cartItemsList = cartRepo.findByUserId(userId);
        Cart[] cartItemsArray = new Cart[cartItemsList.size()];
        cartItemsArray = cartItemsList.toArray(cartItemsArray);
        return cartItemsArray;

    }

}

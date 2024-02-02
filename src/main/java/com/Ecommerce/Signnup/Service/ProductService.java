package com.Ecommerce.Signnup.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.Ecommerce.Signnup.Entity.Product;
import com.Ecommerce.Signnup.Repo.ProductRepo;



@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }
    
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    public Product getProductById( Long id) {
        return productRepo.findById(id)
        .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    
    
}

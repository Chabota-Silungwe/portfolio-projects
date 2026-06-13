package com.zcas.ecommerce.service;

import com.zcas.ecommerce.model.Product;
import com.zcas.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    // Constructor injection allows Spring to hand over the repository instance automatically
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Retrieve all catalog items
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Find a single product item by its ID
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    // Save a brand new item into the database
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
}

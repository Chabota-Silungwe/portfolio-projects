package com.zcas.ecommerce.controller;

import com.zcas.ecommerce.model.Product;
import com.zcas.ecommerce.service.ProductService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ResponseEntity;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Route to GET all products (http://localhost:8080/api/products)
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Route to GET a single item by its ID
    @getMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Route to POST (create) a new item
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }
}

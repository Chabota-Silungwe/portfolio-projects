package com.zcas.ecommerce.service;

import com.zcas.ecommerce.model.CartItem;
import com.zcas.ecommerce.model.OrderRecord;
import com.zcas.ecommerce.model.Product;
import com.zcas.ecommerce.repository.CartRepository;
import com.zcas.ecommerce.repository.OrderRepository;
import com.zcas.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CartAndOrderService {
    private final CartRepository cartRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public CartAndOrderService(CartRepository cartRepository, OrderRepository orderRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    // Cart Operations
    public List<CartItem> getCartItems() { return cartRepository.findAll(); }

    public CartItem addToCart(Long productId, int quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        CartItem item = new CartItem(product, quantity);
        return cartRepository.save(item);
    }

    public void clearCart() { cartRepository.deleteAll(); }

    // Order Operations
    public List<OrderRecord> getAllOrders() { return orderRepository.findAll(); }

    public OrderRecord checkout() {
        List<CartItem> items = cartRepository.findAll();
        if (items.isEmpty()) {
            throw new RuntimeException("Cart is empty");
        }

        // Calculate total amount dynamically
        double total = items.stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();

        // Create and save final order
        OrderRecord order = new OrderRecord(total, "PENDING");
        OrderRecord savedOrder = orderRepository.save(order);

        // Clear shopping cart after success checkout
        cartRepository.deleteAll();
        return savedOrder;
    }
}

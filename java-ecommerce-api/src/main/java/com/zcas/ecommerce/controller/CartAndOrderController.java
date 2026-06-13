package com.zcas.ecommerce.controller;

import com.zcas.ecommerce.model.CartItem;
import com.zcas.ecommerce.model.OrderRecord;
import com.zcas.ecommerce.service.CartAndOrderService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CartAndOrderController {
    private final CartAndOrderService service;

    public CartAndOrderController(CartAndOrderService service) {
        this.service = service;
    }

    @GetMapping("/cart")
    public List<CartItem> viewCart() {
        return service.getCartItems();
    }

    @PostMapping("/cart/add")
    public CartItem addItemToCart(@RequestParam Long productId, @RequestParam int quantity) {
        return service.addToCart(productId, quantity);
    }

    @PostMapping("/checkout")
    public OrderRecord processCheckout() {
        return service.checkout();
    }

    @GetMapping("/orders")
    public List<OrderRecord> viewOrders() {
        return service.getAllOrders();
    }
}

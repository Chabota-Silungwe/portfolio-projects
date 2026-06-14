package com.zcas.ecommerce.service;

import com.zcas.ecommerce.model.CartItem;
import com.zcas.ecommerce.model.OrderRecord;
import com.zcas.ecommerce.model.Product;
import com.zcas.ecommerce.repository.CartRepository;
import com.zcas.ecommerce.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CartAndOrderServiceTest {

    private CartRepository cartRepository;
    private OrderRepository orderRepository;
    private CartAndOrderService service;

    @BeforeEach
    void setUp() {
        // Create Mock copies of repositories using Mockito to isolate the service logic
        cartRepository = mock(CartRepository.class);
        orderRepository = mock(OrderRepository.class);
        service = new CartAndOrderService(cartRepository, orderRepository, null);
    }

    @Test
    void testCheckoutCalculatesTotalAmountCorrectly() {
        // 1. Arrange: Create mock items mimicking a shopping cart configuration
        Product product = new Product("Mechanical Keyboard", 100.00, "RGB Keyboard");
        CartItem item = new CartItem(product, 2); // 100.00 x 2 = 200.00 total calculation target

        when(cartRepository.findAll()).thenReturn(List.of(item));
        when(orderRepository.save(any(OrderRecord.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // 2. Act: Trigger the checkout method calculation engine
        OrderRecord completedOrder = service.checkout();

        // 3. Assert: Verify the calculations evaluate perfectly using JUnit assertions
        assertNotNull(completedOrder);
        assertEquals(200.00, completedOrder.getTotalAmount(), "Total math verification failed");
        assertEquals("PENDING", completedOrder.getStatus());

        // Verify cleanup routines triggered automatically
        verify(cartRepository, times(1)).deleteAll(); 
    }
}

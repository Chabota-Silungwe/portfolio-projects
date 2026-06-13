package com.zcas.ecommerce.repository;

import com.zcas.ecommerce.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<CartItem, Long> {
}

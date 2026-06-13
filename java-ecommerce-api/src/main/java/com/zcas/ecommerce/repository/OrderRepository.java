package com.zcas.ecommerce.repository;

import com.zcas.ecommerce.model.OrderRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderRecord, Long> {
}

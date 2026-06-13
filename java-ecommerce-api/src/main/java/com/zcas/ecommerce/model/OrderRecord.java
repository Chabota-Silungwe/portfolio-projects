package com.zcas.ecommerce.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class OrderRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime orderDate;
    private double totalAmount;
    private String status;

    public OrderRecord() {}

    public OrderRecord(double totalAmount, String status) {
        this.orderDate = LocalDateTime.now();
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDateTime getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDateTime orderDate) { this.orderDate = orderDate; }
    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

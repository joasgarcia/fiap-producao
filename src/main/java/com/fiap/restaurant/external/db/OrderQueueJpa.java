package com.fiap.restaurant.external.db;

import com.fiap.restaurant.entity.OrderStatus;
import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "order_queue")
public class OrderQueueJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "orderId", nullable = false)
    private Long orderId;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(name = "lastUpdated", nullable = false)
    private Date lastUpdated = new Date();

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}

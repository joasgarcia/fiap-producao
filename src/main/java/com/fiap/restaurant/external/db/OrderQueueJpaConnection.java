package com.fiap.restaurant.external.db;

import com.fiap.restaurant.types.db.OrderQueueDatabaseConnection;
import org.springframework.stereotype.Component;

@Component
public class OrderQueueJpaConnection implements OrderQueueDatabaseConnection<OrderQueueJpa> {

    private final OrderQueueRepository orderQueueRepository;

    public OrderQueueJpaConnection(OrderQueueRepository orderQueueRepository) {
        this.orderQueueRepository = orderQueueRepository;
    }

    @Override
    public void save(OrderQueueJpa orderQueue) {
        this.orderQueueRepository.save(orderQueue);
    }

    @Override
    public OrderQueueJpa findByOrderId(Long orderId) {
        return this.orderQueueRepository.findByOrderId(orderId);
    }
}

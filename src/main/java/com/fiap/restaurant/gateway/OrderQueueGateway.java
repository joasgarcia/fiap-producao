package com.fiap.restaurant.gateway;

import com.fiap.restaurant.entity.OrderQueue;
import com.fiap.restaurant.external.db.OrderQueueJpa;
import com.fiap.restaurant.types.db.OrderQueueDatabaseConnection;
import com.fiap.restaurant.types.mapper.OrderQueueMapper;

@SuppressWarnings("unchecked")
public class OrderQueueGateway implements IOrderQueueGateway {

    private final OrderQueueDatabaseConnection orderQueueDatabaseConnection;

    public OrderQueueGateway(OrderQueueDatabaseConnection orderQueueDatabaseConnection) {
        this.orderQueueDatabaseConnection = orderQueueDatabaseConnection;
    }

    @Override
    public void save(OrderQueue orderQueue) {
        OrderQueueJpa orderQueueJpa = new OrderQueueJpa();
        orderQueueJpa.setOrderId(orderQueue.getOrderId());
        orderQueueJpa.setStatus(orderQueue.getStatus());

        this.orderQueueDatabaseConnection.save(orderQueueJpa);
    }

    @Override
    public OrderQueue findByOrderId(Long orderId) {
        OrderQueueJpa orderQueueJpa = (OrderQueueJpa) this.orderQueueDatabaseConnection.findByOrderId(orderId);
        if (orderQueueJpa == null) return null;

        return OrderQueueMapper.INSTANCE.toOrderQueue(orderQueueJpa);
    }
}

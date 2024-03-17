package com.fiap.restaurant.gateway;

import com.fiap.restaurant.entity.OrderQueue;

public interface IOrderQueueGateway {

    void save(OrderQueue orderQueue);

    void update(OrderQueue orderQueue);

    OrderQueue findByOrderId(Long orderId);

}

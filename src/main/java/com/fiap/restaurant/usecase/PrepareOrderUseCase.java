package com.fiap.restaurant.usecase;

import com.fiap.restaurant.entity.OrderQueue;
import com.fiap.restaurant.entity.OrderStatus;
import com.fiap.restaurant.gateway.IOrderQueueGateway;
import com.fiap.restaurant.types.exception.BusinessException;

public class PrepareOrderUseCase {

    public static void prepare(Long orderId, IOrderQueueGateway orderQueueGateway) {
        OrderQueue orderQueue = orderQueueGateway.findByOrderId(orderId);

        if (orderQueue == null) throw new BusinessException("Pedido não encontrado");

        orderQueue.setStatus(OrderStatus.PREPARING);

        orderQueueGateway.update(orderQueue);
    }

}

package com.fiap.restaurant.usecase;

import com.fiap.restaurant.entity.OrderQueue;
import com.fiap.restaurant.entity.OrderStatus;
import com.fiap.restaurant.gateway.IOrderQueueGateway;
import com.fiap.restaurant.types.dto.SaveOrderQueueDTO;
import com.fiap.restaurant.types.exception.BusinessException;

public class OrderQueueUseCase {

    public static void save(SaveOrderQueueDTO saveOrderQueueDTO, IOrderQueueGateway orderQueueGateway) {
        if (orderQueueGateway.findByOrderId(saveOrderQueueDTO.getOrderId()) != null) throw new BusinessException("Pedido já incluído na fila");

        OrderQueue orderQueue = new OrderQueue();
        orderQueue.setOrderId(saveOrderQueueDTO.getOrderId());
        orderQueue.setStatus(OrderStatus.PENDING);

        orderQueueGateway.save(orderQueue);
    }
}

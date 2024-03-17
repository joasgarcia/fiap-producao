package com.fiap.restaurant.usecase;

import com.fiap.restaurant.entity.OrderQueue;
import com.fiap.restaurant.entity.OrderStatus;
import com.fiap.restaurant.gateway.IOrderQueueGateway;
import com.fiap.restaurant.gateway.ProductionOutboundQueueGateway;
import com.fiap.restaurant.types.exception.BusinessException;
import jakarta.transaction.Transactional;

@Transactional
public class FinishOrderUseCase {

    public static void finish(Long orderId, IOrderQueueGateway orderQueueGateway, ProductionOutboundQueueGateway productionOutboundQueueGateway) {
        OrderQueue orderQueue = orderQueueGateway.findByOrderId(orderId);

        if (orderQueue == null) throw new BusinessException("Pedido não encontrado");

        orderQueue.setStatus(OrderStatus.FINISHED);

        orderQueueGateway.update(orderQueue);

        productionOutboundQueueGateway.sendOrderFinished(orderQueue.getOrderId());
    }
}

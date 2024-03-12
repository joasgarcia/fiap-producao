package com.fiap.restaurant.controller;

import com.fiap.restaurant.gateway.IOrderQueueGateway;
import com.fiap.restaurant.gateway.OrderQueueGateway;
import com.fiap.restaurant.types.db.OrderQueueDatabaseConnection;
import com.fiap.restaurant.types.dto.SaveOrderQueueDTO;
import com.fiap.restaurant.usecase.OrderQueueUseCase;
import com.fiap.restaurant.usecase.PrepareOrderUseCase;

public class OrderQueueController {

    public static void save(SaveOrderQueueDTO saveOrderQueueDTO, OrderQueueDatabaseConnection orderQueueDatabaseConnection) {
        IOrderQueueGateway orderQueueGateway = new OrderQueueGateway(orderQueueDatabaseConnection);
        OrderQueueUseCase.save(saveOrderQueueDTO, orderQueueGateway);
    }

    public static void prepare(Long orderId, OrderQueueDatabaseConnection orderQueueDatabaseConnection) {
        IOrderQueueGateway orderQueueGateway = new OrderQueueGateway(orderQueueDatabaseConnection);
        PrepareOrderUseCase.prepare(orderId, orderQueueGateway);
    }

}

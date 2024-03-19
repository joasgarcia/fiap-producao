package com.fiap.restaurant.controller;

import com.fiap.restaurant.gateway.IOrderQueueGateway;
import com.fiap.restaurant.gateway.OrderQueueGateway;
import com.fiap.restaurant.gateway.ProductionOutboundQueueGateway;
import com.fiap.restaurant.types.db.OrderQueueDatabaseConnection;
import com.fiap.restaurant.types.dto.SaveOrderQueueDTO;
import com.fiap.restaurant.usecase.FinishOrderUseCase;
import com.fiap.restaurant.usecase.OrderQueueUseCase;
import com.fiap.restaurant.usecase.PrepareOrderUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class OrderQueueController {

    @Autowired
    private ProductionOutboundQueueGateway productionOutboundQueueGateway;

    public static void save(SaveOrderQueueDTO saveOrderQueueDTO, OrderQueueDatabaseConnection orderQueueDatabaseConnection) {
        IOrderQueueGateway orderQueueGateway = new OrderQueueGateway(orderQueueDatabaseConnection);
        OrderQueueUseCase.save(saveOrderQueueDTO, orderQueueGateway);
    }

    public static void prepare(Long orderId, OrderQueueDatabaseConnection orderQueueDatabaseConnection) {
        IOrderQueueGateway orderQueueGateway = new OrderQueueGateway(orderQueueDatabaseConnection);
        PrepareOrderUseCase.prepare(orderId, orderQueueGateway);
    }

    public void finish(Long orderId, OrderQueueDatabaseConnection orderQueueDatabaseConnection) {
        IOrderQueueGateway orderQueueGateway = new OrderQueueGateway(orderQueueDatabaseConnection);
        FinishOrderUseCase.finish(orderId, orderQueueGateway, productionOutboundQueueGateway);
    }
}

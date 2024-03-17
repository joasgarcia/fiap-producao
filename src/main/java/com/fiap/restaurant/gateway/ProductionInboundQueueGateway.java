package com.fiap.restaurant.gateway;

import com.fiap.restaurant.controller.OrderQueueController;
import com.fiap.restaurant.types.db.OrderQueueDatabaseConnection;
import com.fiap.restaurant.types.dto.OrderSentToProductionDTO;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductionInboundQueueGateway {

    private final OrderQueueDatabaseConnection orderQueueDatabaseConnection;

    public ProductionInboundQueueGateway(OrderQueueDatabaseConnection orderQueueDatabaseConnection) {
        this.orderQueueDatabaseConnection = orderQueueDatabaseConnection;
    }

    @SqsListener(value = "producao-q")
    public void receiveMessage(OrderSentToProductionDTO orderSentToProduction) {
        OrderQueueController.prepare(orderSentToProduction.orderId(), orderQueueDatabaseConnection);
        log.info("message received > ", orderSentToProduction.orderId());
    }
}

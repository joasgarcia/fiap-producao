package com.fiap.restaurant.gateway;

import com.fiap.restaurant.types.db.OrderQueueDatabaseConnection;
import com.fiap.restaurant.types.dto.SaveOrderQueueDTO;
import com.fiap.restaurant.usecase.OrderQueueUseCase;
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

    @SqsListener(value = "${queue.productionInbound.name}")
    public void receiveMessage(SaveOrderQueueDTO saveOrderQueueDTO) {
        IOrderQueueGateway orderQueueGateway = new OrderQueueGateway(this.orderQueueDatabaseConnection);

        OrderQueueUseCase.save(saveOrderQueueDTO, orderQueueGateway);
        log.info("message received > orderId: " + saveOrderQueueDTO.getOrderId());
    }
}

package com.fiap.restaurant.gateway;

import com.fiap.restaurant.types.dto.SqsOrderResponseDTO;
import com.fiap.restaurant.types.dto.SqsOrderResponseType;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductionOutboundQueueGateway {

    @Autowired
    private SqsTemplate sqsTemplate;

    @Value("${queue.productionOutbound.name}")
    private String productionOutboundQueueName;

    public void setSqsTemplate(SqsTemplate sqsTemplate) {
        this.sqsTemplate = sqsTemplate;
    }

    public void sendOrderFinished(Long orderId) {
        SqsOrderResponseDTO sqsOrderResponseDTO = new SqsOrderResponseDTO(SqsOrderResponseType.ORDER_PRODUCTION_FINISHED, orderId);

        this.sqsTemplate.send(this.productionOutboundQueueName, sqsOrderResponseDTO);

        log.info("Message sent " + sqsOrderResponseDTO.getType() +  " > " + orderId);
    }
}

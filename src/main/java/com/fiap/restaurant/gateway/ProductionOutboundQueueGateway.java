package com.fiap.restaurant.gateway;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.restaurant.types.dto.services.ServiceResponseQueueDTO;
import com.fiap.restaurant.types.dto.services.ServiceResponseQueueType;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;

import java.util.Map;

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

    public void sendOrderFinished(Long orderId) throws JsonProcessingException {
        ServiceResponseQueueDTO sqsOrderResponseDTO = new ServiceResponseQueueDTO(
                ServiceResponseQueueType.ORDER_PRODUCTION_FINISHED,
                Map.of("id", orderId));

        String jsonData = toJson(sqsOrderResponseDTO);

        log.info("Payload enviado: " + jsonData);

        send(jsonData);

        log.info("Message sent " + sqsOrderResponseDTO.type() +  " > " + orderId);
    }

    private void send(String message) {
        SqsClient sqsClient = buildClient();

        try (sqsClient) {
            sqsClient.sendMessage(to -> to.queueUrl(this.productionOutboundQueueName).messageBody(message));
        }
    }

    private SqsClient buildClient() {
        return SqsClient.builder()
                .credentialsProvider(DefaultCredentialsProvider.create())
                .region(Region.US_EAST_1)
                .build();
    }

    private String toJson(ServiceResponseQueueDTO data) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(data);
    }
}

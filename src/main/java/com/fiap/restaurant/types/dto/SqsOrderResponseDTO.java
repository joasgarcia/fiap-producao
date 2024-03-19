package com.fiap.restaurant.types.dto;

public class SqsOrderResponseDTO {

    private SqsOrderResponseType type;

    private OrderQueueResponseDTO data;


    public SqsOrderResponseDTO(SqsOrderResponseType type, Long orderId) {
        this.setType(type);

        OrderQueueResponseDTO orderQueueResponseDTO = new OrderQueueResponseDTO();
        orderQueueResponseDTO.setOrderId(orderId);

        this.data = orderQueueResponseDTO;
    }

    public SqsOrderResponseType getType() {
        return type;
    }

    public void setType(SqsOrderResponseType type) {
        this.type = type;
    }

    public OrderQueueResponseDTO getData() {
        return data;
    }
}

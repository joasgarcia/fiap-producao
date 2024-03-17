package com.fiap.restaurant.types.dto;

public class SqsOrderResponseDTO {

    private String type;

    private OrderQueueResponseDTO data;


    public SqsOrderResponseDTO(String type, Long orderId) {
        this.setType(type);

        OrderQueueResponseDTO orderQueueResponseDTO = new OrderQueueResponseDTO();
        orderQueueResponseDTO.setOrderId(orderId);

        this.data = orderQueueResponseDTO;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public OrderQueueResponseDTO getData() {
        return data;
    }
}

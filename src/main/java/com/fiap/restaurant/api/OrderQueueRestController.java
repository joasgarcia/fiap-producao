package com.fiap.restaurant.api;

import com.fiap.restaurant.controller.OrderQueueController;
import com.fiap.restaurant.types.db.OrderQueueDatabaseConnection;
import com.fiap.restaurant.types.dto.SaveOrderQueueDTO;
import com.fiap.restaurant.types.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/queue")
public class OrderQueueRestController {

    private final OrderQueueDatabaseConnection orderQueueDatabaseConnection;

    public OrderQueueRestController(OrderQueueDatabaseConnection orderQueueDatabaseConnection) {
        this.orderQueueDatabaseConnection = orderQueueDatabaseConnection;
    }

    @PostMapping(path = "/")
    public ResponseEntity<?> save(@RequestBody SaveOrderQueueDTO saveOrderQueueDTO) {
        try {
            OrderQueueController.save(saveOrderQueueDTO, orderQueueDatabaseConnection);
            return ResponseEntity.ok(true);
        } catch (BusinessException businessException) {
            return new ResponseEntity<>(businessException.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

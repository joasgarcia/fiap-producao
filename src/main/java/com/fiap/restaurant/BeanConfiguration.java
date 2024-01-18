package com.fiap.restaurant;

import com.fiap.restaurant.external.db.OrderQueueJpa;
import com.fiap.restaurant.types.db.OrderQueueDatabaseConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Autowired
    public OrderQueueDatabaseConnection<OrderQueueJpa> orderQueueDatabaseConnection;
}

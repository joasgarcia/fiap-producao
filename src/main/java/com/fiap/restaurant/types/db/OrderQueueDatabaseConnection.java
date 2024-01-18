package com.fiap.restaurant.types.db;

public interface OrderQueueDatabaseConnection<T> {

    void save(T orderQueue);

    T findByOrderId(Long orderId);

}

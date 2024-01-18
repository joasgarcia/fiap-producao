package com.fiap.restaurant.external.db;

import com.fiap.restaurant.external.db.OrderQueueJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderQueueRepository extends JpaRepository<OrderQueueJpa, Long> {

    OrderQueueJpa findByOrderId(Long orderId);

}

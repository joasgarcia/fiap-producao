package com.fiap.restaurant.types.mapper;

import com.fiap.restaurant.entity.OrderQueue;
import com.fiap.restaurant.external.db.OrderQueueJpa;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderQueueMapper {

    OrderQueueMapper INSTANCE = Mappers.getMapper(OrderQueueMapper.class);

    OrderQueue toOrderQueue(OrderQueueJpa orderQueueJpa);
}

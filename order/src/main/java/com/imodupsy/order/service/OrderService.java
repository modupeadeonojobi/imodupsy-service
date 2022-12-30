package com.imodupsy.order.service;

import com.imodupsy.order.dto.OrderLineItemsDto;
import com.imodupsy.order.dto.OrderRequestDto;
import com.imodupsy.order.mapper.OrderMapper;
import com.imodupsy.order.model.Order;
import com.imodupsy.order.model.OrderLineItems;
import com.imodupsy.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    private final OrderMapper orderMapper;

    public void placeOrder(OrderRequestDto orderRequestDto) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequestDto.getOrderLineItemsDtoList()
                .stream()
                .map(orderMapper::mapToDto)
                .toList();


        order.setOrderLineItemsList(orderLineItems);
        orderRepository.save(order);
    }

}

package com.imodupsy.order.service;

import com.imodupsy.order.dto.InventoryResponseDto;
import com.imodupsy.order.dto.OrderRequestDto;
import com.imodupsy.order.mapper.OrderMapper;
import com.imodupsy.order.model.Order;
import com.imodupsy.order.model.OrderLineItems;
import com.imodupsy.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

	private final OrderRepository orderRepository;

	private final WebClient webClient;

	private final OrderMapper orderMapper;

	public void placeOrder(OrderRequestDto orderRequestDto) {
		Order order = new Order();
		order.setOrderNumber(UUID.randomUUID().toString());

		List<OrderLineItems> orderLineItems = orderRequestDto.getOrderLineItemsDtoList()
				.stream().map(orderMapper::mapToDto).toList();

		order.setOrderLineItemsList(orderLineItems);
		// Retrieve the list of skuCodes.
		List<String> skuCodes = order.getOrderLineItemsList().stream()
				.map(OrderLineItems::getSkuCode).toList();

		// Call inventory service and place order if it's in stock.
		InventoryResponseDto[] inventoryResponsesArray = webClient.get()
				.uri("http://localhost:8082/api/inventory",
						uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
				.retrieve().bodyToMono(InventoryResponseDto[].class).block();
		Arrays.stream(inventoryResponsesArray).forEach(System.out::println);

		// Checking if all the responses from isInStock are the same.
		boolean allProductInStock = Arrays.stream(inventoryResponsesArray).allMatch(InventoryResponseDto::isInStock);

		if (allProductInStock) {
			orderRepository.save(order);
		}
		else {
			throw new IllegalArgumentException(
					"Product is not in stock, please try again later");
		}
	}

}

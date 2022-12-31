package com.imodupsy.order.controller;

import com.imodupsy.order.dto.OrderRequestDto;
import com.imodupsy.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

	private final OrderService orderService;

	@PostMapping
	public ResponseEntity<?> createProduct(@RequestBody OrderRequestDto orderRequestDto) {
		orderService.placeOrder(orderRequestDto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}

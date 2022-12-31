package com.imodupsy.inventory.controller;

import com.imodupsy.inventory.dto.InventoryResponseDto;
import com.imodupsy.inventory.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

	private final InventoryService inventoryService;

	// http://localhost:8082/api/inventory/iphone-13,iphone13-red

	// http://localhost:8082/api/inventory?skuCode=iphone-13&skuCode=iphone13-red
	@GetMapping
	public ResponseEntity<List<InventoryResponseDto>> isInStock(@RequestParam List<String> skuCode) {
		return new ResponseEntity<>(inventoryService.isInStock(skuCode), HttpStatus.OK);
	}

}

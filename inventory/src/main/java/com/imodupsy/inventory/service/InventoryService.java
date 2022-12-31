package com.imodupsy.inventory.service;

import com.imodupsy.inventory.dto.InventoryResponseDto;
import com.imodupsy.inventory.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author iModupsy
 * @created 31/12/2022
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

	private final InventoryRepository inventoryRepository;

	@Transactional(readOnly = true)
	public List<InventoryResponseDto> isInStock(List<String> skuCode) {
		log.info("Checking Inventory");
		return inventoryRepository.findBySkuCodeIn(skuCode).stream()
				.map(inventory -> InventoryResponseDto.builder()
						.skuCode(inventory.getSkuCode())
						.isInStock(inventory.getQuantity() > 0).build())
				.toList();
	}

}

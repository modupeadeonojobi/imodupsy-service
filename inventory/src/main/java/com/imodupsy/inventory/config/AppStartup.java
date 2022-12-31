package com.imodupsy.inventory.config;

import com.imodupsy.inventory.model.Inventory;
import com.imodupsy.inventory.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author iModupsy
 * @created 31/12/2022
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class AppStartup {

	// private final InventoryRepository inventoryRepository;
	//
	// @Override
	// public void onApplicationEvent(ApplicationReadyEvent event) {
	//// loadData();
	// }

	// public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
	// return args -> {
	// Inventory inventory = new Inventory();
	// inventory.setSkuCode("iphone_13");
	// inventory.setQuantity(100);
	//
	// Inventory inventory1 = new Inventory();
	// inventory1.setSkuCode("iphone_13_red");
	// inventory1.setQuantity(0);
	//
	// inventoryRepository.save(inventory);
	// inventoryRepository.save(inventory1);
	// };
	// }

}

package com.imodupsy.order.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author iModupsy
 * @created 31/12/2022
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventoryResponseDto {

	private String skuCode;

	private boolean isInStock;

}

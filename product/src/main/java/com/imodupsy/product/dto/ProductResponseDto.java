package com.imodupsy.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author iModupsy
 * @created 27/12/2022
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {

	private String id;

	private String name;

	private String description;

	private BigDecimal price;

}

package com.imodupsy.product.controller;

import com.imodupsy.product.dto.ProductRequestDto;
import com.imodupsy.product.dto.ProductResponseDto;
import com.imodupsy.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author iModupsy
 * @created 27/12/2022
 */
@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;

	@PostMapping
	public ResponseEntity<?> createProduct(
			@RequestBody ProductRequestDto productRequestDto) {
		productService.createProduct(productRequestDto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<ProductResponseDto>> getAllProducts() {
		return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
	}

}

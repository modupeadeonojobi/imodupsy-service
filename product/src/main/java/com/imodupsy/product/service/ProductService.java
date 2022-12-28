package com.imodupsy.product.service;

import com.imodupsy.product.dto.ProductRequestDto;
import com.imodupsy.product.dto.ProductResponseDto;
import com.imodupsy.product.mapper.ProductMapper;
import com.imodupsy.product.model.Product;
import com.imodupsy.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author iModupsy
 * @created 27/12/2022
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

	private final ProductRepository productRepository;

	private final ProductMapper productMapper;

	public void createProduct(ProductRequestDto productRequestDto) {
		Product product = Product.builder().name(productRequestDto.getName())
				.description(productRequestDto.getDescription())
				.price(productRequestDto.getPrice()).build();

		productRepository.save(product);
		log.info("Product {} is saved", product.getId());
	}

	public List<ProductResponseDto> getAllProducts() {
		List<Product> products = productRepository.findAll();

		return productMapper.mapToProductResponse(products);
	}

}

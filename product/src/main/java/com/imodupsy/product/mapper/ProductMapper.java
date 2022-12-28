package com.imodupsy.product.mapper;

import com.imodupsy.product.dto.ProductResponseDto;
import com.imodupsy.product.model.Product;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author iModupsy
 * @created 27/12/2022
 */
@Mapper(componentModel = "spring")
public abstract class ProductMapper {

	public abstract ProductResponseDto mapToProductResponse(Product product);

	public abstract List<ProductResponseDto> mapToProductResponse(List<Product> product);

}

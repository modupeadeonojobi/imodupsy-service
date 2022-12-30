package com.imodupsy.order.mapper;

import com.imodupsy.order.dto.OrderLineItemsDto;
import com.imodupsy.order.model.OrderLineItems;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author iModupsy
 * @created 27/12/2022
 */
@Mapper(componentModel = "spring")
public abstract class OrderMapper {

	public abstract OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto);

}

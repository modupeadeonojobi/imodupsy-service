package com.imodupsy.order;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.imodupsy.order.model.Order;
import com.imodupsy.order.model.OrderLineItems;
import com.imodupsy.order.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class OrderApplicationTests {

	@Container
	public static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer("postgres:11.1");

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private OrderRepository orderRepository;

	@DynamicPropertySource
	static void setPostgresSQLProperties(DynamicPropertyRegistry dymDynamicPropertyRegistry) {
		dymDynamicPropertyRegistry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
		dymDynamicPropertyRegistry.add("spring.datasource.username", postgreSQLContainer::getUsername);
		dymDynamicPropertyRegistry.add("spring.datasource.password", postgreSQLContainer::getPassword);
	}

	@Test
	public void shouldCreateOrder() throws Exception {
		Order orderRequest = getOrderRequest();
		String orderRequestString = objectMapper.writeValueAsString(orderRequest);

		mockMvc.perform(MockMvcRequestBuilders.post("/api/order")
						.contentType(MediaType.APPLICATION_JSON)
						.content(orderRequestString))
				.andExpect(status().isCreated());
	}

	private Order getOrderRequest() {
		Order order = new Order();
		order.setOrderNumber(UUID.randomUUID().toString());
		order.setOrderLineItemsList(getOrderLineItemsList());
		return order;
	}


	private List<OrderLineItems> getOrderLineItemsList() {
		OrderLineItems orderLineItems = new OrderLineItems();
		orderLineItems.setPrice(BigDecimal.valueOf(129));
		orderLineItems.setQuantity(2);
		orderLineItems.setSkuCode("0091");
		return List.of(orderLineItems);
	}

}

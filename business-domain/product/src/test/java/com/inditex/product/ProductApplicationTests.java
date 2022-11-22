package com.inditex.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ProductApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	void contextLoads() throws Exception {
		String productId = "1";
		mvc.perform(MockMvcRequestBuilders.get("/product/{productId}/similarids").accept(MediaType.APPLICATION_JSON)
				.param("productId", productId)).andExpect(status().isOk());
	}

}

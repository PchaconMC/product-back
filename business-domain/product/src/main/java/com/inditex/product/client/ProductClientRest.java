package com.inditex.product.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.inditex.product.dto.v1.ProductDetail;

@FeignClient(name="simulado-1",url = "localhost:3001")
public interface ProductClientRest {
	
	@GetMapping("/product/{productId}/similarids")
	public String[] getProductSimilar(@PathVariable String productId);
	@GetMapping("/product/{productId}")
	public ProductDetail getProduct(@PathVariable String productId);
}

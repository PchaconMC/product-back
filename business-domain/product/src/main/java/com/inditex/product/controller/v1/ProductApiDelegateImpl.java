package com.inditex.product.controller.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.inditex.product.dto.v1.ProductDetail;
import com.inditex.product.service.ProductService;


@Service
public class ProductApiDelegateImpl implements ProductApiDelegate {


	@Autowired
	ProductService productService;
	
	@Override
	public ResponseEntity<List<ProductDetail>> getProductSimilar(String productId) {
		List<ProductDetail> productDetails = productService.similarProduct(productId);
		return ResponseEntity.ok(productDetails);
	}
}

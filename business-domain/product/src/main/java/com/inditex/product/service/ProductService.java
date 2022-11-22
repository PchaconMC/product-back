package com.inditex.product.service;

import java.util.List;


import com.inditex.product.dto.v1.ProductDetail;

public interface ProductService {
	public List<ProductDetail> similarProduct(String productId);
}

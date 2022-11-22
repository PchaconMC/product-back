package com.inditex.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;

import com.inditex.product.client.ProductClientRest;
import com.inditex.product.dto.v1.ProductDetail;


@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private CircuitBreakerFactory cbFactory;

	@Autowired
	ProductClientRest productClientRest;

	@Override
	public List<ProductDetail> similarProduct(String productId) {
		List<ProductDetail> productDetails = new ArrayList<ProductDetail>(); 
		ProductDetail productDetail = cbFactory.create("product").run(
				()->productClientRest.getProduct(productId));

		if(productDetail!=null)	{
			String[] productsSimilar = productClientRest.getProductSimilar(productDetail.getId().toString());
			for(String idProduct:productsSimilar) {
				productDetails.add(cbFactory.create("similarProduct").run(
						()->productClientRest.getProduct(idProduct),e -> null));
			}
		}
		return productDetails;
	}

}

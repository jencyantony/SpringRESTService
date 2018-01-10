package com.spring.dao;

import com.spring.model.ProductRegistrationDO;

public interface ProductDAO {

	public ProductRegistrationDO registerProduct(ProductRegistrationDO productDO);
	
	public ProductRegistrationDO getProductDetails(String registrationId);
	
}

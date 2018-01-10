package com.spring.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dao.ProductDAOImpl;
import com.spring.model.ProductRegistrationDO;

@RestController
public class ProductController {

	@Autowired
	private ProductDAOImpl daoImpl;
	
	@RequestMapping(value="/registerProduct", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public ProductRegistrationDO registerProduct(@RequestBody ProductRegistrationDO productDAO){
		return daoImpl.registerProduct(productDAO);
	}
	
	@RequestMapping(value="/getProduct/{id}", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody ProductRegistrationDO getProduct(@PathVariable("id") String registrationId){
		return daoImpl.getProductDetails(registrationId);
	}
}

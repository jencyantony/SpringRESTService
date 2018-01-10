package com.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.spring.model.ProductRegistrationDO;

@Repository
public class ProductDAOImpl implements ProductDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public ProductRegistrationDO registerProduct(ProductRegistrationDO productDO) {
		String sql="insert into product_registration(lastname, firstname, email, phoneNumber, "
				+ "addressLine1, addressLine2, city, state, zipCode, country, modelName, productId, purchasedFrom, purchaseDate) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				pstmt.setString(1, productDO.getLastname());
				pstmt.setString(2, productDO.getFirstname());
				pstmt.setString(3, productDO.getEmail());
				pstmt.setString(4, productDO.getPhoneNumber());
				pstmt.setString(5, productDO.getAddressLine1());
				pstmt.setString(6, productDO.getAddressLine2());
				pstmt.setString(7, productDO.getCity());
				pstmt.setString(8, productDO.getState());
				pstmt.setString(9, productDO.getZipCode());
				pstmt.setString(10, productDO.getCountry());
				pstmt.setString(11, productDO.getModelName());
				pstmt.setString(12, productDO.getProductId());
				pstmt.setString(13, productDO.getPurchasedFrom());
				pstmt.setString(14, productDO.getPurchaseDate());
				return pstmt;
			}
		}, generatedKeyHolder);
		productDO.setRegistrationId(generatedKeyHolder.getKey().toString());
		return productDO;
	}

	public ProductRegistrationDO getProductDetails(String registrationId) {
		String sql = "select * from product_registration where registrationId = ?";
		return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<ProductRegistrationDO>(ProductRegistrationDO.class), registrationId);
	}
}
package com.bolivar.mucuru.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JDBCAddressRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;


	public void deleteProductService(Integer idAddress) {
	
		String sql ="DELETE FROM ADDRESS_PRODUCT_SERVICE WHERE FK_ID_ADDRESS=?";
		jdbcTemplate.update(sql,  idAddress);
	}
	

}

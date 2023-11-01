package com.bolivar.mucuru.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JDBCAddressRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// Método que elimina la relación entre productos y servicios con dirección
	public void deleteProductService(Integer idAddress) {
		String sql ="DELETE FROM ADDRESS_PRODUCT_SERVICE WHERE FK_ID_ADDRESS=?";
		jdbcTemplate.update(sql,  idAddress);
	}
	
	// Método que elimina todas las direcciones
	public void deleteAllAddress() {
		String sql ="CALL DELETE_ALL_ADDRESS()";
		jdbcTemplate.update(sql);
	}

}

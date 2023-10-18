package com.bolivar.mucuru.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bolivar.mucuru.entity.Product_Service;

@Repository
public interface Product_ServiceRepository extends JpaRepository<Product_Service, Integer>{

	@Query(value = "SELECT * from PRODUCT_SERVICE WHERE TYPE_PRODUCT_SERVICE = :type", nativeQuery = true)
	public List<Product_Service> findAllProduct_Service(@Param("type") String type);	
}

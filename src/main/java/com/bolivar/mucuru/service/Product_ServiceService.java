package com.bolivar.mucuru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolivar.mucuru.repository.Product_ServiceRepository;

import com.bolivar.mucuru.entity.Product_Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class Product_ServiceService {
	
	// Repositorio a utilizar
	@Autowired
	Product_ServiceRepository product_serviceRepository;
	
	public List<Product_Service> allProduct_Service(String type) {
		List<Product_Service> list = product_serviceRepository.findAllProduct_Service(type);
		return list;
	}

}

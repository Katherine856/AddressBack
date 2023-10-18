package com.bolivar.mucuru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bolivar.mucuru.entity.Product_Service;
import com.bolivar.mucuru.service.Product_ServiceService;

@RestController
@RequestMapping("/product_service")
@CrossOrigin(origins = "*")
public class Product_ServiceController {
	
	// Servicio a utilizar
	@Autowired
	Product_ServiceService product_serviceService;
	
	@GetMapping("/all/products")
	public ResponseEntity<List<Product_Service>> getAllProduct() {
		List<Product_Service> list = product_serviceService.allProduct_Service("Producto");
		return new ResponseEntity<List<Product_Service>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/all/services")
	public ResponseEntity<List<Product_Service>> getAllService() {
		List<Product_Service> list = product_serviceService.allProduct_Service("Servicio");
		return new ResponseEntity<List<Product_Service>>(list, HttpStatus.OK);
	}
}

package com.bolivar.mucuru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bolivar.mucuru.entity.Country;

import com.bolivar.mucuru.service.CountryService;

@RestController
@RequestMapping("/country")
@CrossOrigin(origins = "*")
public class CountryController {
	
	// Servicio a utilizar
	@Autowired
	CountryService countryService;
	
	// Método que trae todos los paises
	@GetMapping("/all")
	public ResponseEntity<List<Country>> getAll() {
		List<Country> list = countryService.allCountrys();
		return new ResponseEntity<List<Country>>(list, HttpStatus.OK);
	}
}

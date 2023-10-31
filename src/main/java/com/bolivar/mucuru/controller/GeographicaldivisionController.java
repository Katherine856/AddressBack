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

import com.bolivar.mucuru.entity.Geographicaldivision;
import com.bolivar.mucuru.service.GeographicaldivisionService;

@RestController
@RequestMapping("/geographicaldivision")
@CrossOrigin(origins = "*")
public class GeographicaldivisionController {
	
	// Servicio a utilizar
	@Autowired
	GeographicaldivisionService geographicaldivisionService;
	
	// Método que trae todas las divisiones geograficas por pais
	@GetMapping("/all/{idCountry}")
	public ResponseEntity<List<Geographicaldivision>> getAll(@PathVariable(value = "idCountry") Integer idCountry) {
		List<Geographicaldivision> list = geographicaldivisionService.allGeographicaldivision(idCountry);
		return new ResponseEntity<List<Geographicaldivision>>(list, HttpStatus.OK);
	}
}

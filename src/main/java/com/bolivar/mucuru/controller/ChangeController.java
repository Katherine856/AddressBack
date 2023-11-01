package com.bolivar.mucuru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bolivar.mucuru.entity.Change;
import com.bolivar.mucuru.service.ChangeService;

@RestController
@RequestMapping("/change")
@CrossOrigin(origins = "*")
public class ChangeController {

	@Autowired
	ChangeService changeService;
	
	// Método que traer todas las direcciones
	@GetMapping("/all")
	public ResponseEntity<List<Change>> getAll() {
		List<Change> list = changeService.getAll();
		return new ResponseEntity<List<Change>>(list, HttpStatus.OK);
	}
	
}

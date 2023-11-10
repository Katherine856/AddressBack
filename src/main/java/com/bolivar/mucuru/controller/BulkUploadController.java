package com.bolivar.mucuru.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bolivar.mucuru.service.BulkUploadAddresses;

@RestController
@RequestMapping("/address")
@CrossOrigin(origins = "*")
public class BulkUploadController {
	
	@Autowired
	BulkUploadAddresses bulkUploadAddress;

	@PostMapping("/massiveAddresses")
	public ResponseEntity<?> cargar(@RequestParam("addresses") MultipartFile archivo) {
		try {
			// Se sube el archivo
			bulkUploadAddress.subirArchivo(bulkUploadAddress.saveFile(archivo));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok().build();
	}
}

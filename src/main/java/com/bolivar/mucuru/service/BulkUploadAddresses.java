package com.bolivar.mucuru.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bolivar.mucuru.entity.Address;
import com.bolivar.mucuru.entity.Geographicaldivision;
import com.bolivar.mucuru.repository.GeographicaldivisionRepository;

@Service
public class BulkUploadAddresses {
	
	public Address massiveAddress = new Address();
	public Geographicaldivision geoDiv = new Geographicaldivision();
	
	// Servicio a utilizar
	@Autowired
	AddressService addressService;
	
	// Repositorio a utilizar
	@Autowired
	GeographicaldivisionRepository geographicaldivisionRepository;

	// Directorio donde se almacenarán los archivos
	private String carpeta = "src/main/java/files/";

	// Método para guardar los archivos
	public String guardar(MultipartFile file) throws IOException {
		byte[] bytes = file.getBytes();
		Path path = Paths.get(carpeta + file.getOriginalFilename());
		Files.write(path, bytes);
		return path.toString();
	}

	// Método para registrar los datos del archivo
	@SuppressWarnings("resource")
	public void subirArchivo(String txt) {
		@SuppressWarnings("unused")
		int auxRegistros = 0;
		try {
			BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(txt), "utf-8"));
			String registro = "";
			while ((registro = buffer.readLine()) != null) {
				massiveAddress = new Address();
				auxRegistros++;
				String[] columna = registro.split(";");
				// Condición para saber si se registra o se actualiza la dirección
				if (columna[0].equals("null")) {
					massiveAddress.setIdAddress(null);
				} else {
					massiveAddress.setIdAddress(Integer.parseInt(columna[0]));
				}
				// Get de la division geografica para asignarla a la dirección
				geoDiv = geographicaldivisionRepository.findById(columna[1]).get();
				massiveAddress.setGeographicalDivision(geoDiv);
				massiveAddress.setInfoAddress(columna[2]);
				massiveAddress.setLatitude(Integer.parseInt(columna[3]));
				massiveAddress.setLongitude(Integer.parseInt(columna[4]));
				if (columna[5].equals("null")) {
					massiveAddress.setResidential(null);
				} else {
					massiveAddress.setResidential(columna[5]);
				}
				if (columna[6].equals("null")) {
					massiveAddress.setBuilding(null);
				} else {
					massiveAddress.setBuilding(columna[6]);
				}
				if (columna[7].equals("null")) {
					massiveAddress.setTower(null);
				} else {
					massiveAddress.setTower(columna[7]);
				}
				if (columna[8].equals("null")) {
					massiveAddress.setFloor(null);
				} else {
					massiveAddress.setFloor(Integer.parseInt(columna[8]));
				}
				if (columna[9].equals("null")) {
					massiveAddress.setApartment(null);
				} else {
					massiveAddress.setApartment(Integer.parseInt(columna[9]));
				}
				
				// Se guarda la dirección
				Address addressAux = addressService.saveAddress(massiveAddress);
				// Se Asignan los productos y servicios a la dirección
				
				String[] Product_Service = columna[10].split(",");
				
				for(int i=0;i<Product_Service.length; i++) {
					addressService.assignProduct_Service(addressAux.getIdAddress(), Integer.parseInt(Product_Service[i]));
				}
				// Se limpia el objeto para permitir inserción de todos las direcciones disponibles
				massiveAddress = null;
			}   
		} catch (IOException e) {  
			e.printStackTrace();
		}
	}
}

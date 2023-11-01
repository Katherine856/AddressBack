package com.bolivar.mucuru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bolivar.mucuru.entity.Address;
import com.bolivar.mucuru.service.AddressService;
import com.bolivar.mucuru.service.ChangeService;

@RestController
@RequestMapping("/address")
@CrossOrigin(origins = "*")
public class AddressController {

	// Servicios a utilizar
	@Autowired
	AddressService addressService;

	@Autowired
	ChangeService changeService;

	// Método que permite crear una dirección
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody Address addressDTO) {
		if (addressService.existsByIdAddress(addressDTO.getIdAddress()))
			return new ResponseEntity<>(new String("Esta dirrecion ya existe"), HttpStatus.BAD_REQUEST);
		try {
			Address address = new Address();
			address.setIdAddress(addressDTO.getIdAddress());
			address.setGeographicalDivision(addressDTO.getGeographicalDivision());
			address.setInfoAddress(addressDTO.getInfoAddress());
			address.setLatitude(addressDTO.getLatitude());
			address.setLongitude(addressDTO.getLongitude());
			address.setResidential(addressDTO.getResidential());
			address.setBuilding(addressDTO.getBuilding());
			address.setTower(addressDTO.getTower());
			address.setFloor(addressDTO.getFloor());
			address.setApartment(addressDTO.getApartment());
			addressService.saveAddress(address);
			for (int i = 0; i < addressDTO.getProduct_service().size(); i++) {
				addressService.assignProduct_Service(address.getIdAddress(),
						addressDTO.getProduct_service().get(i).getIdProduct_Service());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new String("Guardado"), HttpStatus.CREATED);
	}

	// Método que traer todas las direcciones
	@GetMapping("/all")
	public ResponseEntity<List<Address>> getAll() {
		List<Address> list = addressService.getAll();
		return new ResponseEntity<List<Address>>(list, HttpStatus.OK);
	}

	// Método que traer todas las direcciones por pais
	@GetMapping("/all/{idCountry}")
	public ResponseEntity<List<Address>> getAllByCountry(@PathVariable(value = "idCountry") Integer idCountry) {
		List<Address> list = addressService.getAllByCountry(idCountry);
		return new ResponseEntity<List<Address>>(list, HttpStatus.OK);
	}

	// Método que traer a una dirección mediante su id
	@GetMapping("/{idAddress}")
	public ResponseEntity<Address> getOne(@PathVariable(value = "idAddress") Integer idAddress) {
		Address address = addressService.findById(idAddress).orElse(null);
		return new ResponseEntity<Address>(address, HttpStatus.OK);
	}

	// Método que permite actualizar una dirección mediante su id
	@PutMapping("/update/{idAddress}/{idUser}")
	public ResponseEntity<?> update(@RequestBody Address address, @PathVariable("idAddress") Integer idAddress,
			@PathVariable("idUser") Integer idUser) {
		if (!addressService.existsByIdAddress(idAddress))
			return new ResponseEntity<>(new String("No existe esa dirección"), HttpStatus.NOT_FOUND);
		Address addressDetails = addressService.findById(idAddress).get();
		addressDetails.setGeographicalDivision(address.getGeographicalDivision());
		addressDetails.setInfoAddress(address.getInfoAddress());
		addressDetails.setLatitude(address.getLatitude());
		addressDetails.setLongitude(address.getLongitude());
		addressDetails.setResidential(address.getResidential());
		addressDetails.setBuilding(address.getBuilding());
		addressDetails.setTower(address.getTower());
		addressDetails.setFloor(address.getFloor());
		addressDetails.setApartment(address.getApartment());
		addressService.saveAddress(addressDetails);
		addressService.deleteByProduct_Service(idAddress);
		for (int i = 0; i < address.getProduct_service().size(); i++) {
			try {
				addressService.assignProduct_Service(addressDetails.getIdAddress(),
						address.getProduct_service().get(i).getIdProduct_Service());
			} catch (Exception e) {

			}
		}
		changeService.assignProduct_Service("Actualizar", addressDetails.getIdAddress(), idUser);
		return new ResponseEntity<>(new String("Dirección actualizada"), HttpStatus.CREATED);
	}

	// Método que permite borrar una dirección mediante su id
	@DeleteMapping("/delete/{idAddress}")
	public ResponseEntity<?> delete(@PathVariable(value = "idAddress") Integer idAddress) {
		if (!addressService.findById(idAddress).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		addressService.deleteById(idAddress);
		return ResponseEntity.ok().build();
	}

	// Método que permite borrar una dirección mediante su id
	@GetMapping("/delete/all")
	public ResponseEntity<?> deleteAll() {
		addressService.deleteAllAddress();
		return ResponseEntity.ok().build();
	}

}

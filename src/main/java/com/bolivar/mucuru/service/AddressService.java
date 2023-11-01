package com.bolivar.mucuru.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolivar.mucuru.repository.AddressRepository;
import com.bolivar.mucuru.repository.JDBCAddressRepository;

import jakarta.transaction.Transactional;

import com.bolivar.mucuru.entity.Address;

@Service
@Transactional
public class AddressService {

	// Repositorio a utilizar
	@Autowired
	AddressRepository addressRepository;

	@Autowired
	JDBCAddressRepository jdbcAddressRepository;

	// Método que pemrite encontrar una dirección mediante su ID
	public Optional<Address> findById(Integer idAddress) {
		return addressRepository.findById(idAddress);
	}

	// Método que permite guardar una dirección
	public Address saveAddress(Address address) {
		Address addr = addressRepository.save(address);
		return addr;
	}

	// Método que permite asignar producto(s) y/o servicio(s) a una dirección
	public void assignProduct_Service(Integer idAddress, Integer idProductService) {
		try {
			addressRepository.assignProduct_Service(idAddress, idProductService);
		} catch (Exception e) {

		}
	}

	// Método que permite hacer borrado físico de una dirección
	public void deleteById(Integer idAddress) {
		addressRepository.deleteById(idAddress);
	}

	// Método que permite listar todos las direcciones registradas
	public List<Address> getAll() {
		List<Address> list = addressRepository.findAll();
		return list;
	}

	// Método que permite listar todos las direcciones registradas
	public List<Address> getAllByCountry(Integer idCountry) {
		List<Address> list = addressRepository.findByCountry(idCountry);
		return list;
	}

	// Método que permite verificar si existe una dirección mediante su ID
	public boolean existsByIdAddress(Integer idAddress) {
		return addressRepository.existsByIdAddress(idAddress);
	}

	// Método que elimina los productos y servicios relacionados a una dirección
	public void deleteByProduct_Service(Integer idAddress) {
		jdbcAddressRepository.deleteProductService(idAddress);
	}

	// Método que permite verificar si existe una dirección mediante su ID
	public void deleteAllAddress() {
		jdbcAddressRepository.deleteAllAddress();
	}

}

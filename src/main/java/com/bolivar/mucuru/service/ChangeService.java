package com.bolivar.mucuru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolivar.mucuru.entity.Address;
import com.bolivar.mucuru.entity.Change;
import com.bolivar.mucuru.repository.ChangeRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ChangeService {

	// Repositorio a utilizar
	@Autowired
	ChangeRepository changeRepository;
	
	// Método que permite asignar producto(s) y/o servicio(s) a una dirección
	public void assignProduct_Service(String type, Integer idAddress, Integer idUser) {
		try {
			changeRepository.createChange(type, idAddress, idUser);
		} catch (Exception e) {
			
		}
	}
	
	// Método que permite listar todos los cambios registrados
	public List<Change> getAll() {
		List<Change> list = changeRepository.findAll();
		return list;
	}
	
}

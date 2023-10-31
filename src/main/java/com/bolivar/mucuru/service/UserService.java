package com.bolivar.mucuru.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolivar.mucuru.entity.User;
import com.bolivar.mucuru.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {
	
	// Repositorio a utilizar
	@Autowired
	UserRepository userRepository;
	
	// Método que verifica si un usuario existe por su id
	public boolean existsByDocumento(Integer idUser) {
		return userRepository.existsById(idUser);
	}
	
	// Método que trae un usuario por su id
	public Optional<User> findById(Integer idUser) {
		return userRepository.findById(idUser);
	}
	
}

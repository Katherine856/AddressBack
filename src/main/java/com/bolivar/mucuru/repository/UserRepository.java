package com.bolivar.mucuru.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bolivar.mucuru.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	// Método que trae un usuario por su id
	Optional<User> findById(Integer idUser);
	
	// Método que verifica si un usuario existe por su id
	boolean existsById(Integer idUser);
	
}

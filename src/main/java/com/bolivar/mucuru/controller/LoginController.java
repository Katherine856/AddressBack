package com.bolivar.mucuru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bolivar.mucuru.DTO.CredentialsDTO;
import com.bolivar.mucuru.entity.User;
import com.bolivar.mucuru.service.UserService;

@RestController
@RequestMapping("/address")
@CrossOrigin(origins = "*")
public class LoginController {

	// Servicios a utilizar
	@Autowired
	UserService userService;

	//Método que permite confirmar las credenciales
	@PostMapping("/login")
	public User Login(@RequestBody CredentialsDTO credentials) {
		try {
			if (credentials != null) {
				if (credentials.getIdUser() != null && !credentials.getPassword().isBlank()) {
					//Traemos la información del usuario ingresado
					User userlog = userService.findById(credentials.getIdUser()).get();
					//Verificacamos que el usuario y la contraseña coincidan
					if (userlog.getIdUser().equals(credentials.getIdUser()) && userlog.getPassword().equals(credentials.getPassword())) { 
						return userlog; //Devolvemos el usuario completo 
					}else {
						return null;
					}
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return null;
	}
	
}

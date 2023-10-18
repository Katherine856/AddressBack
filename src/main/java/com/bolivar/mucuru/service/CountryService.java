package com.bolivar.mucuru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolivar.mucuru.repository.CountryRepository;

import com.bolivar.mucuru.entity.Country;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CountryService {
	
	// Repositorio a utilizar
	@Autowired
	CountryRepository countryRepository;
	
	public List<Country> allCountrys() {
		List<Country> list = countryRepository.findAll();
		return list;
	}

}

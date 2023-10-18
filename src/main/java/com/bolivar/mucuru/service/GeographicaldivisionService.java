package com.bolivar.mucuru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolivar.mucuru.repository.CountryRepository;
import com.bolivar.mucuru.repository.GeographicaldivisionRepository;
import com.bolivar.mucuru.entity.Country;
import com.bolivar.mucuru.entity.Geographicaldivision;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class GeographicaldivisionService {
	
	// Repositorio a utilizar
	@Autowired
	GeographicaldivisionRepository geographicaldivisionRepository;
	
	public List<Geographicaldivision> allGeographicaldivision(Integer idCountry) {
		List<Geographicaldivision> list = geographicaldivisionRepository.findAllGeoDiv(idCountry);
		return list;
	}

}

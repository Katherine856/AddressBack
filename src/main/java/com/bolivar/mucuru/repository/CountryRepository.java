package com.bolivar.mucuru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bolivar.mucuru.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer>{

	
}

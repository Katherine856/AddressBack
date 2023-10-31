package com.bolivar.mucuru.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bolivar.mucuru.entity.Geographicaldivision;

@Repository
public interface GeographicaldivisionRepository extends JpaRepository<Geographicaldivision, String>{
	
	// Método que permite encontrar una dirección mediante su ID
	Optional<Geographicaldivision> findById(String idGeoDiv);
	
	// Método que trae toda la división geografica de un pais
	@Query(value = "SELECT G.K_ID, G.NAME, G.TIMEZONE, G.FK_ID_COUNTRY FROM GEOGRAPHICALDIVISION G, COUNTRY C WHERE G.FK_ID_COUNTRY = C.K_ID AND C.K_ID = :idCountry", nativeQuery = true)
	public List<Geographicaldivision> findAllGeoDiv(@Param("idCountry") Integer idCountry);	
}

package com.bolivar.mucuru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bolivar.mucuru.entity.Change;

@Repository
public interface ChangeRepository extends JpaRepository<Change, Integer> {
	
	//Metodo que permite almacenar el cambio de una dirección
	@Query(value = "CALL ADD_CHANGE_ADDRESS(:type, :idAddress, :idUser)", nativeQuery = true)
	public void createChange(@Param("type") String type, @Param("idAddress") Integer idAddress, @Param("idUser") Integer idUser);
	
}

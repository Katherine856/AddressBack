package com.bolivar.mucuru.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bolivar.mucuru.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
	
		// Método que permite encontrar una dirección mediante su ID
		Optional<Address> findById(Integer idAddress);

		// Método que permite verificar si existe una dirección mediante su ID
		boolean existsByIdAddress(Integer idAddress);

		// Método que permite hacer borrado físico una dirección mediante su ID
		void deleteById(Integer idAddress);
		
		// Método que permite hacer la asignación de los productos y servicios asociados a una dirección
		@Query(value = "CALL ADD_PRODUCT_SERVICE(:idAddress, :idProduct_Service)", nativeQuery = true)
		public void assignProduct_Service(@Param("idAddress") Integer idAddress, @Param("idProduct_Service") Integer idProduct_Service);

		// Método que permite hacer borrado físico los productos y servicios asociados a una dirección
		@Query(value = "DELETE FROM ADDRESS_PRODUCT_SERVICE WHERE FK_ID_ADDRESS=:idAddress", nativeQuery = true)
		void deleteByProduct_Service(@Param("idAddress") Integer idAddress);
		
		// Método que trae todas las direcciónes filtradas por pais
		@Query(value = "SELECT  /*+ ALL_ROWS */ A.* FROM ADDRESS A, GEOGRAPHICALDIVISION G, COUNTRY C WHERE A.FK_ID_GEOGRAPHICALDIVISION = G.K_ID AND G.FK_ID_COUNTRY = C.K_ID AND C.K_ID =:idCountry", nativeQuery = true)
		public List<Address> findByCountry(@Param("idCountry") Integer idCountry);
}

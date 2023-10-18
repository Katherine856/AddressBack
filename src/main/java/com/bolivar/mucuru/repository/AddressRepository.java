package com.bolivar.mucuru.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bolivar.mucuru.DAO.AddressListDAO;
import com.bolivar.mucuru.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
	
		// Método que permite encontrar una dirección mediante su ID
		Optional<Address> findById(Integer idAddress);

		// Método que permite verificar si existe una dirección mediante su ID
		boolean existsByIdAddress(Integer idAddress);

		// Método que permite hacer borrado físico una dirección mediante su ID
		void deleteById(Integer idAddress);
		
		
		@Query(value = "SELECT C.K_ID, C.IMAGE, A.INFO_ADDRESS FROM ADDRESS A, GEOGRAPHICALDIVISION G, COUNTRY C WHERE A.FK_ID_GEOGRAPHICALDIVISION = G.K_ID AND G.FK_ID_COUNTRY = C.K_ID", nativeQuery = true)
		public List<AddressListDAO> addressAll();	
		
		@Query(value = "CALL ADD_PRODUCT_SERVICE(:idAddress, :idProduct_Service)", nativeQuery = true)
		public void assignProduct_Service(@Param("idAddress") Integer idAddress, @Param("idProduct_Service") Integer idProduct_Service);

}

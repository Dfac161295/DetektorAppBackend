package com.detektorcompany.detektorcompany.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.detektorcompany.detektorcompany.model.Vehiculo;

@Repository
public interface VehiculoDao extends JpaRepository<Vehiculo,String>{
	
	@Query("SELECT v FROM Vehiculo v WHERE v.propietario.dbid_ = 7")
	List<Vehiculo> findAllVehiculesAvailables();
	
	@Query("SELECT v FROM Vehiculo v WHERE v.propietario.dbid_ = :dbid")
	List <Vehiculo> findAllVehiculesByIdPropietary(@Param("dbid") Integer dbid_);
	
	
	
}

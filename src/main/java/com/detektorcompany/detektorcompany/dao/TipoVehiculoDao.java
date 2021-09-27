package com.detektorcompany.detektorcompany.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.detektorcompany.detektorcompany.model.TipoVehiculo;

@Repository
public interface TipoVehiculoDao extends JpaRepository<TipoVehiculo,Integer>{

	
}

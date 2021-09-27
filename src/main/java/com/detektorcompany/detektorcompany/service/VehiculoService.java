package com.detektorcompany.detektorcompany.service;

import java.util.List;

import com.detektorcompany.detektorcompany.model.Vehiculo;

public interface VehiculoService extends CRUD<Vehiculo>{
	
	List<Vehiculo> findAllVehiculesAvailable();
	List<Vehiculo> findAllVehiculesByIdPropietary(Integer dbid);

}

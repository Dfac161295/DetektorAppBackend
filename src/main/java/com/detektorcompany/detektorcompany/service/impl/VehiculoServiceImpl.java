package com.detektorcompany.detektorcompany.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.detektorcompany.detektorcompany.dao.VehiculoDao;
import com.detektorcompany.detektorcompany.model.Vehiculo;
import com.detektorcompany.detektorcompany.service.VehiculoService;


@Service
public class VehiculoServiceImpl implements VehiculoService{

	@Autowired
	private VehiculoDao dao;
	
	
	
	@Override
	public List<Vehiculo> findAll() {
		return dao.findAll();
	}

	@Override
	public Vehiculo create(Vehiculo obj) {		
			return dao.save(obj);		
	}

	@Override
	public Vehiculo find(Vehiculo obj) {
		return dao.findById(obj.getPlaca()).get();
	}

	@Override
	public Vehiculo update(Vehiculo obj) {
		return dao.save(obj);
	}

	@Override
	public void delete(Vehiculo obj) {
		dao.delete(obj);
	}
	
	@Override
	public List<Vehiculo> findAllVehiculesAvailable() {
		return dao.findAllVehiculesAvailables();
	}

	@Override
	public List<Vehiculo> findAllVehiculesByIdPropietary(Integer dbid) {
		return dao.findAllVehiculesByIdPropietary(dbid);
	}

	

}

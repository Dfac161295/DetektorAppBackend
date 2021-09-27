package com.detektorcompany.detektorcompany.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.detektorcompany.detektorcompany.dao.TipoVehiculoDao;
import com.detektorcompany.detektorcompany.model.TipoVehiculo;
import com.detektorcompany.detektorcompany.service.TipoVehiculoService;

@Service
public class TipoVehiculoServiceImpl implements TipoVehiculoService{

	@Autowired
	private TipoVehiculoDao dao;
	
	@Override
	public List<TipoVehiculo> findAll() {
	return dao.findAll();
	}

	@Override
	public TipoVehiculo create(TipoVehiculo obj) {
		return dao.save(obj);
	}

	@Override
	public TipoVehiculo find(TipoVehiculo obj) {
		return dao.findById(obj.getDbid_()).get();
	}

	@Override
	public TipoVehiculo update(TipoVehiculo obj) {
		return dao.save(obj);
	}

	@Override
	public void delete(TipoVehiculo obj) {
		dao.deleteById(obj.getDbid_());
	}

}

package com.detektorcompany.detektorcompany.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.detektorcompany.detektorcompany.dao.PropietarioDao;
import com.detektorcompany.detektorcompany.model.Propietario;
import com.detektorcompany.detektorcompany.service.PropietarioService;

@Service 
public class PropietarioServiceImpl implements PropietarioService{

	@Autowired
	private PropietarioDao dao;
	
	@Override
	public List<Propietario> findAll() {
	return dao.findAll();	
	}

	@Override
	public Propietario create(Propietario obj) {
		return dao.save(obj);
	}

	@Override
	public Propietario find(Propietario obj) {
		return dao.findById(obj.getDbid_()).get();
	}

	@Override
	public Propietario update(Propietario obj) {
		return dao.save(obj);
	}

	@Override
	public void delete(Propietario obj) {
		 dao.deleteById(obj.getDbid_());
	}

}

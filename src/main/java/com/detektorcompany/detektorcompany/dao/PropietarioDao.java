package com.detektorcompany.detektorcompany.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.detektorcompany.detektorcompany.model.Propietario;

@Repository
public interface PropietarioDao extends JpaRepository<Propietario,Integer>{

	
}

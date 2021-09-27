package com.detektorcompany.detektorcompany.service;

import java.util.List;

public interface CRUD<T> {
	

	List<T> findAll();

	T create(T obj);

	T find(T id);

	T update(T obj);

	void delete(T obj);

}

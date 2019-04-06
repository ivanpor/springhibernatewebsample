package com.formacion.springhibernatesample.model.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<E,K extends Serializable> {

	public List<E> findAll();
	public E findById(K id);
	public void save(E entity);
	public void update(E entity);
	public void delete(K id);
}

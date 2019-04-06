package com.formacion.springhibernatesample.model.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.formacion.springhibernatesample.model.dao.GenericDao;

@Repository("genericDao")
public class GenericDaoImpl<E, K extends Serializable> implements GenericDao<E, K>{

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory(){
	    return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
	    this.sessionFactory = sessionFactory;
	}
	
	public List<E> findAll() {
		CriteriaQuery<E> criteria = this.sessionFactory.getCriteriaBuilder().createQuery(this.getEntityClass());
		criteria.from(this.getEntityClass());
		return this.sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
	}

	public E findById(K id) {
		return this.sessionFactory.getCurrentSession().find(this.getEntityClass(), id);
	}

	public void save(E entity) {
		this.sessionFactory.getCurrentSession().save(entity);
	}

	public void update(E entity) {
		this.sessionFactory.getCurrentSession().merge(entity);
	}

	public void delete(K id) {
		this.sessionFactory.getCurrentSession().delete(this.findById(id));
	}
	
	@SuppressWarnings("unchecked")
	private Class<E> getEntityClass(){
		 return (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
}

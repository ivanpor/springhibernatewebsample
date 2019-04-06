package com.formacion.springhibernatesample.model.hibernate;

import org.springframework.stereotype.Repository;

import com.formacion.springhibernatesample.model.dao.ProductDao;
import com.formacion.springhibernatesample.model.entity.Product;

@Repository("productDao")
public class ProductDaoImpl extends GenericDaoImpl<Product, Integer> implements ProductDao{

}

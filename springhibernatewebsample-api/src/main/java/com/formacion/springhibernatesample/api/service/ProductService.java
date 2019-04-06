package com.formacion.springhibernatesample.api.service;

import java.util.List;

import com.formacion.springhibernatesample.api.dto.ProductDto;
import com.formacion.springhibernatesample.api.exception.ProductNotFoundException;

public interface ProductService {
	
	public List<ProductDto> findAll();
	public ProductDto findById(Integer id) throws ProductNotFoundException;
	public void save(ProductDto productDto);
	public void update(ProductDto productDto) throws ProductNotFoundException;
	public void delete(Integer id) throws ProductNotFoundException;

}

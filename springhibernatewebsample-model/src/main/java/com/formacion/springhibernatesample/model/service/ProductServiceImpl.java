package com.formacion.springhibernatesample.model.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacion.springhibernatesample.api.dto.ProductDto;
import com.formacion.springhibernatesample.api.exception.ProductNotFoundException;
import com.formacion.springhibernatesample.api.service.ProductService;
import com.formacion.springhibernatesample.model.converter.ProductConverter;
import com.formacion.springhibernatesample.model.dao.ProductDao;
import com.formacion.springhibernatesample.model.entity.Product;

@Service("productService")
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private ProductConverter productConverter;

	@Transactional(readOnly = true)
	public List<ProductDto> findAll() {
		return this.productConverter.listEntityToDto(this.productDao.findAll());
	}

	@Transactional(readOnly = true)
	public ProductDto findById(Integer id) throws ProductNotFoundException {
		Product product = this.productDao.findById(id);
		if(Objects.isNull(product)) {
			throw new ProductNotFoundException("Product not found");
		}
		return this.productConverter.entityToDto(product);
	}

	@Transactional
	public void save(ProductDto productDto) {
		this.productDao.save(this.productConverter.dtoToEntity(productDto));
	}

	@Transactional
	public void update(ProductDto productDto) throws ProductNotFoundException {
		Product product = this.productDao.findById(productDto.getId());
		if(Objects.isNull(product)) {
			throw new ProductNotFoundException("Product not found");
		}
		this.productDao.update(this.productConverter.dtoToEntity(productDto));
	}

	@Transactional
	public void delete(Integer id) throws ProductNotFoundException {
		Product product = this.productDao.findById(id);
		if(Objects.isNull(product)) {
			throw new ProductNotFoundException("Product not found");
		}
		this.productDao.delete(id);
	}
}

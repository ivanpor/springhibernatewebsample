package com.formacion.springhibernatesample.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import com.formacion.springhibernatesample.api.dto.ProductDto;
import com.formacion.springhibernatesample.api.exception.ProductNotFoundException;
import com.formacion.springhibernatesample.api.service.ProductService;

@RequestMapping
@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@ResponseBody
	@RequestMapping(value="products", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<ProductDto> findAll() {
		return this.productService.findAll();
	}
	
	@ResponseBody
	@RequestMapping(value="products/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ProductDto findById(@PathVariable final Integer id) throws ProductNotFoundException {
		return this.productService.findById(id);
	}
	
	@ResponseStatus(code=HttpStatus.OK, reason="Product created")
	@RequestMapping(value="products", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public void save(@RequestBody final ProductDto productDto) {
		this.productService.save(productDto);
	}

	@ResponseStatus(code=HttpStatus.OK, reason="Product updated")
	@RequestMapping(value="products", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody final ProductDto productDto) throws ProductNotFoundException {
    	this.productService.update(productDto);
	}
	
	@ResponseStatus(code=HttpStatus.OK, reason="Product deleted")
	@RequestMapping(value="products/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable final Integer id) throws ProductNotFoundException {
		this.productService.delete(id);
	}
}

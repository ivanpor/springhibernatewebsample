package com.formacion.springhibernatesample.model.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.formacion.springhibernatesample.api.dto.ProductDto;
import com.formacion.springhibernatesample.model.entity.Product;

@Component("productConverter")
public class ProductConverter {
	
	public Product dtoToEntity(ProductDto productDto) {
		Product product = new Product();
		product.setId(productDto.getId());
		product.setName(productDto.getName());
		product.setDescription(productDto.getDescription());
		return product;
	}
	
	public List<Product> listDtoToEntity(List<ProductDto> listProductDto) {
		List<Product> listProduct = new ArrayList<Product>();
		
		for(ProductDto productDto : listProductDto) {
			listProduct.add(this.dtoToEntity(productDto));
		}
		return listProduct;
	}
	
	public ProductDto entityToDto(Product product) {
		ProductDto productDto = new ProductDto();
		productDto.setId(product.getId());
		productDto.setName(product.getName());
		productDto.setDescription(product.getDescription());
		return productDto;
	}
	
	
	public List<ProductDto> listEntityToDto(List<Product> listProduct) {
		List<ProductDto> listProductDto = new ArrayList<ProductDto>();
		
		for(Product product : listProduct) {
			listProductDto.add(this.entityToDto(product));
		}
		return listProductDto;
	}
}

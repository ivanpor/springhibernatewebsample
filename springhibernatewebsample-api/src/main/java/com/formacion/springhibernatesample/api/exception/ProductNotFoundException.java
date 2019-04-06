package com.formacion.springhibernatesample.api.exception;

public class ProductNotFoundException extends Exception {

	private static final long serialVersionUID = -4585018797831031181L;
	
	public ProductNotFoundException(String message) {
		super(message);
	}

}

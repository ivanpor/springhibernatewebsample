package com.formacion.springhibernatesample.web.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.formacion.springhibernatesample.api.dto.ErrorDto;
import com.formacion.springhibernatesample.api.exception.ProductNotFoundException;

@ControllerAdvice
public class ProductNotFoundAdvice {

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseBody
    @ResponseStatus(code=HttpStatus.NOT_FOUND, reason="Product not found")
    public ErrorDto handleProductNotFoundException(ProductNotFoundException e) {
        ErrorDto response = new ErrorDto(e.getMessage());
        return response;
    }
}
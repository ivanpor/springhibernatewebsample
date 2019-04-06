package com.formacion.springhibernatesample.api.dto;

public class ErrorDto {

	private String error;

	public ErrorDto() {}
	
	public ErrorDto(String error) {
		super();
		this.error = error;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "ErrorDto [error=" + error + "]";
	}
}

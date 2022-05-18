package com.products.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CategoryNotFoundException extends RuntimeException {

	public CategoryNotFoundException(String menssage) {
		super(menssage);
	}

	private static final long serialVersionUID = 1L;

}

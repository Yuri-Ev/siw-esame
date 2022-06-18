package com.example.demo.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.demo.model.Piatto;
import com.example.demo.service.PiattoService;

public class PiattoValidator implements Validator{
	
	@Autowired
	private PiattoService piattoService;

	@Override
	public boolean supports(Class<?> clazz) {
		return Piatto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (piattoService.alreadyExists((Piatto) target ))
			errors.reject("piatto.duplicato");
		
	}

}

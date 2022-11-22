package com.kruger.demo.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

public class UsuarioValidationErrorBuilder {
	
	public static UsuarioValidationError fromBindingError(Errors errors) {
		UsuarioValidationError error = 
				new UsuarioValidationError("validation error" + errors.getErrorCount() + " errors");
					for(ObjectError objectError: errors.getAllErrors()) {
						error.addValidationError(objectError.getDefaultMessage());
					}
	
	return error;
						
	}

}

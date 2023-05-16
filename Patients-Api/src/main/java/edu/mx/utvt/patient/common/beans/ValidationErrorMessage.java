package edu.mx.utvt.patient.common.beans;

import java.util.List;

import org.springframework.http.HttpStatus;

public class ValidationErrorMessage extends ErrorResponse {

	private List<ValidationMessage> validations;
	
	public ValidationErrorMessage() {
		super();
	}
	
	public ValidationErrorMessage(HttpStatus status, String message, List<ValidationMessage> validations) {
		super(status, message);
		this.validations = validations;
	}
	
	public List<ValidationMessage> getValidations() {
		return validations;
	}

	public void setValidations(List<ValidationMessage> validations) {
		this.validations = validations;
	}	
	
}

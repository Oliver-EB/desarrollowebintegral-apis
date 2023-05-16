package edu.mx.utvt.patient.config;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import edu.mx.utvt.patient.common.beans.ErrorResponse;
import edu.mx.utvt.patient.common.beans.ValidationErrorMessage;
import edu.mx.utvt.patient.common.beans.ValidationMessage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ ConstraintViolationException.class })
	protected ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException constraints) {

		List<ValidationMessage> errors = null;

		errors = constraints.getConstraintViolations().stream()
				.map(error -> new ValidationMessage(error.getRootBeanClass().toString(),
						error.getPropertyPath().toString(), error.getMessageTemplate()))
				.collect(Collectors.toList());
		String message = "Unable to submit due to some missing data";

		return this.buildResponseEntity(new ValidationErrorMessage(HttpStatus.BAD_REQUEST, message, errors));
	}

	@ExceptionHandler({ SQLIntegrityConstraintViolationException.class })
	public ResponseEntity<Object> handleSqlIntegrityException(HttpServletRequest req,
			SQLIntegrityConstraintViolationException ex) {

		String message = "Unable to submit post: " + ex.getMessage();
		return buildResponseEntity(new ErrorResponse(HttpStatus.BAD_REQUEST, message));
	}

	private ResponseEntity<Object> buildResponseEntity(ErrorResponse errorResponse) {
		System.err.println("buildResponseEntity");
		return new ResponseEntity<Object>(errorResponse, errorResponse.getStatus());
	}

}

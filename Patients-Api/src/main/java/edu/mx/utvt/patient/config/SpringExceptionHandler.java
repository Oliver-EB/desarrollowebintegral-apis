package edu.mx.utvt.patient.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import edu.mx.utvt.patient.common.beans.ErrorResponse;

//@ControllerAdvice
public class SpringExceptionHandler extends ExceptionHandlerExceptionResolver {
	
	@ExceptionHandler(org.springframework.web.HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<Object> handleControllerException(HttpMediaTypeNotSupportedException ex, WebRequest req)
    {
        System.err.println("SpringExceptionHandler");
		//return null;
        
        
		ErrorResponse errorResponse = null;
        ex.printStackTrace();
        errorResponse = new ErrorResponse();
        errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        errorResponse.setMessage(ex.getMessage());
        return new ResponseEntity<Object>(errorResponse,
            HttpStatus.valueOf(errorResponse.getStatus().value()));
            
        
    }

}

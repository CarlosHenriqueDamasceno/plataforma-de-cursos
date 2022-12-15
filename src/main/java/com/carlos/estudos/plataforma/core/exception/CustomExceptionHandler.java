package com.carlos.estudos.plataforma.core.exception;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RestController
public class CustomExceptionHandler{
    
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> genericExceptionHandler(
        Exception ex, WebRequest request){
            
        ExceptionResponse exceptionResponse = new ExceptionResponse(
            new Date(), 
            ex.getMessage(), 
            request.getDescription(false));

        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);

    }
    
    @ExceptionHandler(BindException.class)
    public final ResponseEntity<ExceptionResponse> notAcceptableExceptionHandler(
    		BindException ex, WebRequest request){
    	
    	String[] message = new String[100];
    	List<ObjectError> errors = ex.getAllErrors();
    	for (ObjectError error : errors) {
			message = error.getCodes();
		}
    	
    	System.out.println(message);
    	
        ExceptionResponse exceptionResponse = new ExceptionResponse(
            new Date(), 
            ex.getMessage(),
            request.getDescription(false));        
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(RecordNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleRecordNotFountException(
        Exception ex, WebRequest request){
            
        ExceptionResponse exceptionResponse = new ExceptionResponse(
            new Date(), 
            ex.getMessage(), 
            request.getDescription(false));

        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);

    }
}

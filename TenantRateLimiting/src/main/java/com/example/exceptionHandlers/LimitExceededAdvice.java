/**
 * 
 */
package com.example.exceptionHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.exceptions.LimitExceededException;

/**
 * @author vivek
 *
 */
@ControllerAdvice
public class LimitExceededAdvice {
	
	@ExceptionHandler(value = {LimitExceededException.class})
	protected ResponseEntity<Object> defaultResponse(Exception ex){
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.PRECONDITION_REQUIRED);
	}
}

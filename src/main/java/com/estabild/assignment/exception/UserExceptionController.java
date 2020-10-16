package com.estabild.assignment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author sanjaya
 * This is for returning proper error messages with the proper http status when exception occurs
 */
@ControllerAdvice
public class UserExceptionController {
	
	   @ExceptionHandler(value = UsernameAlreadyExistsException.class)
	   public ResponseEntity<Object> getResponseForUsernameAlreadyExistsException(UsernameAlreadyExistsException exception) {
	      return new ResponseEntity<>(UsernameAlreadyExistsException.errorMessage, HttpStatus.BAD_REQUEST);
	   }
	   
	   @ExceptionHandler(value = AuthenticationFailureException.class)
	   public ResponseEntity<Object> getResponseForAuthenticationFailureException(AuthenticationFailureException exception) {
	      return new ResponseEntity<>(AuthenticationFailureException.errorMessage, HttpStatus.UNAUTHORIZED);
	   }
	   
	   @ExceptionHandler(value = UsernameNotFoundException.class)
	   public ResponseEntity<Object> getResponseForUsernameNotFoundException(UsernameNotFoundException exception) {
	      return new ResponseEntity<>(UsernameNotFoundException.errorMessage, HttpStatus.NOT_FOUND);
	   }
	}

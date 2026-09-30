package com.projeto.SIARRE.advice;

import com.projeto.SIARRE.exception.ConflictException;
import com.projeto.SIARRE.exception.NotFoundException;
import com.projeto.SIARRE.exception.RelationshipAlreadyExistsException;
import com.projeto.SIARRE.exception.RestErrorClass;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<RestErrorClass> notFoundExceptionHandler(NotFoundException exception){
    RestErrorClass restErrorClass = new RestErrorClass(HttpStatus.NOT_FOUND, exception.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(restErrorClass);
  }

  @ExceptionHandler(ConflictException.class)
  public ResponseEntity<RestErrorClass> relationshipAlreadyExistsException(ConflictException exception){
    RestErrorClass restErrorClass = new RestErrorClass(HttpStatus.CONFLICT, exception.getMessage());
    return ResponseEntity.status(HttpStatus.CONFLICT).body(restErrorClass);
  }

  @ExceptionHandler(AuthenticationException.class)
  public ResponseEntity<RestErrorClass> authenticationException(AuthenticationException exception){
    RestErrorClass restErrorClass = new RestErrorClass(HttpStatus.UNAUTHORIZED, "Email ou senha incorretos!");
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(restErrorClass);
  }



}

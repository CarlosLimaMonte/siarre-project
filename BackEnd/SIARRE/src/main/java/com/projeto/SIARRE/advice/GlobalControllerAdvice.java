package com.projeto.SIARRE.advice;

import com.projeto.SIARRE.exception.NotFoundException;
import com.projeto.SIARRE.exception.RelationshipAlreadyExistsException;
import com.projeto.SIARRE.exception.RestErrorClass;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<RestErrorClass> notFoundExceptionHandler(NotFoundException exception){
    RestErrorClass restErrorClass = new RestErrorClass(HttpStatus.NOT_FOUND, exception.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(restErrorClass);
  }

  @ExceptionHandler(RelationshipAlreadyExistsException.class)
  public ResponseEntity<RestErrorClass> RelationshipAlreadyExistsException(RelationshipAlreadyExistsException exception){
    RestErrorClass restErrorClass = new RestErrorClass(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(restErrorClass);
  }



}

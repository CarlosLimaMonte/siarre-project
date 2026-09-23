package com.projeto.SIARRE.exception;

public class RelationshipAlreadyExistsException extends RuntimeException {

  public RelationshipAlreadyExistsException() {
    super("Esse relacionamento já existe!");
  }
}

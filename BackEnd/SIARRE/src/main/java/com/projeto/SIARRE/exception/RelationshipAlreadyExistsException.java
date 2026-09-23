package com.projeto.SIARRE.exception;

public class RelationshipAlreadyExistsException extends ConflictException {

  public RelationshipAlreadyExistsException() {
    super("Esse relacionamento já existe!");
  }
}

package com.projeto.SIARRE.exception;

public class CpfAlreadyRegisteredException extends ConflictException {

  public CpfAlreadyRegisteredException() {
    super("CPf já cadastrado!");
  }
}

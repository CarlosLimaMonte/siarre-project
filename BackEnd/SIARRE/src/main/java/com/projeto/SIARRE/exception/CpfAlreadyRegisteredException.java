package com.projeto.SIARRE.exception;

public class CpfAlreadyRegisteredException extends RuntimeException {

  public CpfAlreadyRegisteredException() {
    super("CPf já cadastrado!");
  }
}

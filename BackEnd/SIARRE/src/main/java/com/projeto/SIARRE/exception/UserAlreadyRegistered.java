package com.projeto.SIARRE.exception;

public class UserAlreadyRegistered extends ConflictException {

  public UserAlreadyRegistered() {
    super("Usuário já cadastrado!!");
  }
}

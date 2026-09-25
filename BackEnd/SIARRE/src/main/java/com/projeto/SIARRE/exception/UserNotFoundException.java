package com.projeto.SIARRE.exception;

public class UserNotFoundException extends NotFoundException {

  public UserNotFoundException() {
    super("Usuário não localizado!");
  }
}

package com.projeto.SIARRE.exception;

public class OptionDoesntBelongThisQuestionException extends ConflictException {

  public OptionDoesntBelongThisQuestionException() {
    super("A opção não pertence a essa questão!");
  }
}

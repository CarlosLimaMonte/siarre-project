package com.projeto.SIARRE.exception;

public class FonarQuestionNotFoundException extends NotFoundException {

  public FonarQuestionNotFoundException() {
    super("Questão não localizada!");
  }
}

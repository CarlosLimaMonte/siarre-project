package com.projeto.SIARRE.exception;

public class ScoreIsEmptyException extends BusinessException {

  public ScoreIsEmptyException() {
    super("O total de pontos ainda não foi calculado!");
  }
}

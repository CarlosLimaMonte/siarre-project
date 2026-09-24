package com.projeto.SIARRE.entity.dto;

import com.projeto.SIARRE.entity.FonarAnswer;
import com.projeto.SIARRE.entity.FonarAssessment;
import com.projeto.SIARRE.entity.FonarOption;
import com.projeto.SIARRE.entity.FonarQuestion;
import jakarta.validation.constraints.NotNull;

public record FonarAnswerCreateDto(
    @NotNull(message = "O número da questão não pode estar em branco!")
    Long questionId,
    @NotNull(message = "A opção não pode estar em branco!")
    Long optionId
) {

  public FonarAnswer toEntity(FonarQuestion question, FonarAssessment assessment, FonarOption option){
    return new FonarAnswer(null, question, assessment, option);
  }

}

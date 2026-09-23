package com.projeto.SIARRE.entity.dto;

import com.projeto.SIARRE.entity.FonarAnswer;
import com.projeto.SIARRE.entity.FonarAssessment;
import com.projeto.SIARRE.entity.FonarOption;
import com.projeto.SIARRE.entity.FonarQuestion;

public record FonarAnswerCreateDto(
    Long questionId,
    Long assessmentId,
    Long optionId
) {

  public FonarAnswer toEntity(FonarQuestion question, FonarAssessment assessment, FonarOption option){
    return new FonarAnswer(null, question, assessment, option);
  }

}

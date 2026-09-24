package com.projeto.SIARRE.entity.dto;

import com.projeto.SIARRE.entity.FonarAnswer;

public record FonarAnswerDto(
    Long id,
    Long questionId,
    Long assessmentId,
    Long optionId
) {

  public static FonarAnswerDto fromEntity(FonarAnswer entity){
    return new FonarAnswerDto(
        entity.getId(),
        entity.getQuestion().getId(),
        entity.getFonarAssessment().getId(),
        entity.getFonarOption().getId()
    );
  }

}

package com.projeto.SIARRE.entity.dto;

import com.projeto.SIARRE.entity.FonarAssessment;
import com.projeto.SIARRE.enumClass.RiskLevel;
import java.time.LocalDateTime;
import java.util.List;

public record FonarAssessmentDto(
    Long id,
    Long victimId,
    Long aggressorId,
    Integer score,
    Long userId,
    LocalDateTime createdTime,
    RiskLevel suggestedRiskLevel,
    RiskLevel validatedRiskLevel,
    LocalDateTime validatedIn,
    List<FonarAnswerDto> fonarAnswerDtoList
) {

  public static FonarAssessmentDto fromEntity(FonarAssessment entity){
    return new FonarAssessmentDto(
        entity.getId(),
        entity.getVictim().getId(),
        entity.getAggressor().getId(),
        entity.getScore(),
        entity.getProfessionalValidatedBy().getId(),
        entity.getCreatedDate(),
        entity.getSuggestedRiskLevel(),
        entity.getValidatedRiskLevel(),
        entity.getValidatedIn(),
        entity.getFonarAnswerList().stream().map(FonarAnswerDto :: fromEntity).toList()
    );
  }

}

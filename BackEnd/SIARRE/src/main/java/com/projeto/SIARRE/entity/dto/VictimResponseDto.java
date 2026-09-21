package com.projeto.SIARRE.entity.dto;

import com.projeto.SIARRE.entity.FonarAssessment;
import com.projeto.SIARRE.entity.RelationshipVictimAggressor;
import com.projeto.SIARRE.entity.Victim;
import com.projeto.SIARRE.enumClass.Education;
import com.projeto.SIARRE.enumClass.GenderIdentity;
import com.projeto.SIARRE.enumClass.Nationality;
import com.projeto.SIARRE.enumClass.SexualOrientation;
import java.time.LocalDate;
import java.util.List;

public record VictimResponseDto (
    Long id,
    String name,
    String socialName,
    String cpf,
    LocalDate dateOfBirth,
    GenderIdentity genderIdentity,
    SexualOrientation sexualOrientation,
    Education education,
    Nationality nationality,
    // Need to create a DTO for RelationshipVictimAggressor entity.
    List<RelationshipVictimAggressorDto> relationshipVictimAggressors,
    // Need to create a DTO for FonarAssessment entity.
    List<FonarAssessmentDto> fonarAssessmentList
){
  public static VictimResponseDto fromEntity(Victim victim){
    return new VictimResponseDto(
        victim.getId(),
        victim.getName(),
        victim.getSocialName(),
        victim.getCpf(),
        victim.getDateOfBirth(),
        victim.getGenderIdentity(),
        victim.getSexualOrientation(),
        victim.getEducation(),
        victim.getNationality(),
        victim.getRelationshipVictimAggressorList() != null ?
          victim.getRelationshipVictimAggressorList().stream().map(RelationshipVictimAggressorResponseDto :: fromEntity).toList() : List.of(),
        victim.getFonarAssessmentList() != null ?
            victim.getFonarAssessmentList().stream().map(FonarAssessmentResponseDto :: fromEntity).toList() : List.of()
    );
  }

}

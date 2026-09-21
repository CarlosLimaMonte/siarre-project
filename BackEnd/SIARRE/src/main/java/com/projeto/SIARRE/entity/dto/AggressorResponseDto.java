package com.projeto.SIARRE.entity.dto;

import com.projeto.SIARRE.entity.Aggressor;
import com.projeto.SIARRE.entity.RelationshipVictimAggressor;
import com.projeto.SIARRE.enumClass.Education;
import com.projeto.SIARRE.enumClass.GenderIdentityAggressor;
import com.projeto.SIARRE.enumClass.Nationality;
import com.projeto.SIARRE.enumClass.SexualOrientation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

public record AggressorResponseDto (
    Long id,
    String name,
    String socialName,
    LocalDate dateOfBirth,
    Integer age,
    GenderIdentityAggressor genderIdentity,
    SexualOrientation sexualOrientation,
    Education education,
    Nationality nationality,
    // Need to create a RelationshipVictimAggressorDto
    List<RelationshipVictimAggressorDto> relationshipVictimAggressorList
) {

  public static AggressorResponseDto fromEntity(Aggressor aggressor){

    return new AggressorResponseDto(
        aggressor.getId(),
        aggressor.getName(),
        aggressor.getSocialName(),
        aggressor.getDateOfBirth(),
        aggressor.getAge(),
        aggressor.getGenderIdentity(),
        aggressor.getSexualOrientation(),
        aggressor.getEducation(),
        aggressor.getNationality(),
        aggressor.getRelationshipVictimAggressorList() != null ?
            aggressor.getRelationshipVictimAggressorList().stream().map(RelationshipVictimAggressorDto :: fromEntity).toList() : List.of()
    );

  }

}

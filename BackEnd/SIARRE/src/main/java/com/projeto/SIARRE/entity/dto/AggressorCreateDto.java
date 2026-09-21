package com.projeto.SIARRE.entity.dto;

import com.projeto.SIARRE.entity.Aggressor;
import com.projeto.SIARRE.enumClass.Education;
import com.projeto.SIARRE.enumClass.GenderIdentityAggressor;
import com.projeto.SIARRE.enumClass.Nationality;
import com.projeto.SIARRE.enumClass.SexualOrientation;
import java.time.LocalDate;

public record AggressorCreateDto(
    String name,
    String socialName,
    LocalDate dateOfBirth,
    Integer age,
    GenderIdentityAggressor genderIdentity,
    SexualOrientation sexualOrientation,
    Education education,
    Nationality nationality
) {
  public Aggressor toEntity(){
    return new Aggressor(null, name, socialName, dateOfBirth, age, genderIdentity, sexualOrientation,
        education, nationality);
  }


}

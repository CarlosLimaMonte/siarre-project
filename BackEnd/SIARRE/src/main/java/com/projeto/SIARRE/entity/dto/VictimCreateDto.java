package com.projeto.SIARRE.entity.dto;

import com.projeto.SIARRE.entity.Victim;
import com.projeto.SIARRE.enumClass.Education;
import com.projeto.SIARRE.enumClass.GenderIdentity;
import com.projeto.SIARRE.enumClass.Nationality;
import com.projeto.SIARRE.enumClass.SexualOrientation;
import java.time.LocalDate;

public record VictimCreateDto (
    String name,
    String socialName,
    String cpf,
    LocalDate dateOfBirth,
    GenderIdentity genderIdentity,
    SexualOrientation sexualOrientation,
    Education education,
    Nationality nationality
){

  public Victim toEntity() {
    return new Victim(null, name, socialName, cpf, dateOfBirth, genderIdentity, sexualOrientation,
        education, nationality);
  }

}

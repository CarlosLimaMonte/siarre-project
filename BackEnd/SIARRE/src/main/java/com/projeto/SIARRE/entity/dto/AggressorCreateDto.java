package com.projeto.SIARRE.entity.dto;

import com.projeto.SIARRE.entity.Aggressor;
import com.projeto.SIARRE.enumClass.Education;
import com.projeto.SIARRE.enumClass.GenderIdentityAggressor;
import com.projeto.SIARRE.enumClass.Nationality;
import com.projeto.SIARRE.enumClass.SexualOrientation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public record AggressorCreateDto(
    @NotBlank(message = "Nome não pode estar em branco!")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres.")
    String name,
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres.")
    String socialName,
    @Past(message = "A data de nascimento deve estar no passado.")
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

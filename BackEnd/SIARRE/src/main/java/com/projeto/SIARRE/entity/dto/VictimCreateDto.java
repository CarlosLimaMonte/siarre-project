package com.projeto.SIARRE.entity.dto;

import com.projeto.SIARRE.entity.Victim;
import com.projeto.SIARRE.enumClass.Education;
import com.projeto.SIARRE.enumClass.GenderIdentity;
import com.projeto.SIARRE.enumClass.Nationality;
import com.projeto.SIARRE.enumClass.SexualOrientation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import org.hibernate.validator.constraints.br.CPF;

public record VictimCreateDto (
    @NotBlank(message = "Nome não pode estar em branco!")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres.")
    String name,
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres.")
    String socialName,
    @CPF(message = "CPF inválido!")
    String cpf,
    @NotBlank(message = "Data de nascimento não pode estar em branco!")
    @Past(message = "A data de nascimento deve estar no passado.")
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

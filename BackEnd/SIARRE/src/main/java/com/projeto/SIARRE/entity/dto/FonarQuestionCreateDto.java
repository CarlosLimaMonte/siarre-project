package com.projeto.SIARRE.entity.dto;

import com.projeto.SIARRE.entity.FonarOption;
import com.projeto.SIARRE.entity.FonarQuestion;
import com.projeto.SIARRE.enumClass.TypeQuestion;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public record FonarQuestionCreateDto(
    @NotBlank(message = "O texto precisa estar preenchido!")
    @Size(min = 3, max = 100, message = "O texto precisa ter entre 3 e 100 caracteres!")
    String texto,
    @NotBlank(message = "O tipo de questão precisa ser preenchido!")
    TypeQuestion typeQuestion,
    List<Long> optionIds,
    Boolean required
) {

  public FonarQuestion toEntity(List<FonarOption> ListFonarOptions){
    return new FonarQuestion(
        null, texto, typeQuestion, ListFonarOptions, required
    );
  }

}

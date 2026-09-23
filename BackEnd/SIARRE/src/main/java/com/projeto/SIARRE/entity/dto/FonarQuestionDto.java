package com.projeto.SIARRE.entity.dto;

import com.projeto.SIARRE.entity.FonarOption;
import com.projeto.SIARRE.entity.FonarQuestion;
import com.projeto.SIARRE.enumClass.TypeQuestion;
import java.util.List;

public record FonarQuestionDto(
    Long id,
    String texto,
    TypeQuestion typeQuestion,
    List<Long> optionIds,
    Boolean required
) {
  public static FonarQuestionDto fromEntity(FonarQuestion entity){
    return new FonarQuestionDto(
        entity.getId(),
        entity.getTexto(),
        entity.getTypeQuestion(),
        entity.getOptionsList().stream().map(FonarOption::getId).toList(),
        entity.getRequired()
    );
  }


}

package com.projeto.SIARRE.entity.dto;

import com.projeto.SIARRE.entity.Aggressor;
import com.projeto.SIARRE.entity.FonarAnswer;
import com.projeto.SIARRE.entity.FonarAssessment;
import com.projeto.SIARRE.entity.Victim;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public record FonarAssessmentCreateDto(
    @NotNull(message = "A vítima precisa ser preenchido!")
    Long victimId,
    @NotNull(message = "O agressor precisa ser preenchido!")
    Long aggressorId,
    @NotEmpty(message = "As respostas precisam estar preenchidas!")
    List<@Valid FonarAnswerCreateDto> answerCreateDtoList
) {

  public FonarAssessment toEntity(Victim victim, Aggressor aggressor, List<FonarAnswer> fonarAnswerList){

    return new FonarAssessment(
        null, victim, aggressor, 0, null, 0, 0, null, fonarAnswerList
    );

  }

}

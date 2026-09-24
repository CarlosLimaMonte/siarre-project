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
    Long aggressorId
) {

  public FonarAssessment toEntity(Victim victim, Aggressor aggressor){

    return new FonarAssessment(
        null, victim, aggressor, 0, null, null, null, null, null
    );

  }

}

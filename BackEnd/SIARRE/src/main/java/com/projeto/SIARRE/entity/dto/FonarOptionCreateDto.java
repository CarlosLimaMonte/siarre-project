package com.projeto.SIARRE.entity.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FonarOptionCreateDto(
  @NotBlank(message = "O label não pode estar em branco!")
  String label,
  @NotBlank(message = "O value não pode estar em branco!")
  String value,
  @NotNull(message = "O score não pode estar em branco!")
  @Min(value = 0, message = "O valor mínimo é 0")
  @Max(value = 5, message = "O valor máximo é 5")
  Integer score,
  @NotNull(message = "É preciso sinalizar se a questão é critical ou não!")
  Boolean critical
) {

}

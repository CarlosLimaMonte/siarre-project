package com.projeto.SIARRE.entity.dto;

import com.projeto.SIARRE.entity.FonarOption;

public record FonarOptionCreateDto(
  String label,
  String value,
  Integer score
) {

}

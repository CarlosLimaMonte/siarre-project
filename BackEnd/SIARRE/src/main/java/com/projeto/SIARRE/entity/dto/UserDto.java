package com.projeto.SIARRE.entity.dto;

import com.projeto.SIARRE.entity.FonarAssessment;
import com.projeto.SIARRE.entity.User;
import com.projeto.SIARRE.enumClass.UserRoles;
import java.util.List;

public record UserDto(
    Long id,
    UserRoles role,
    List<Long> fonarIds,
    String email
) {

  public static UserDto fromEntity(User user) {
    return new UserDto(
        user.getId(),
        user.getRole(),
        user.getFonarAssessmentList() != null ? user.getFonarAssessmentList().stream().map(
            FonarAssessment::getId).toList() : null,
        user.getEmail()
    );
  }


}

package com.projeto.SIARRE.entity.dto;

import com.projeto.SIARRE.entity.User;
import com.projeto.SIARRE.enumClass.UserRoles;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserCreateDto(
    // IT WILL BE REMOVED JUST FOR TEST
    UserRoles role,
    @NotBlank (message = "O email não pode estar em branco!")
    @Email(message = "Use um email válido!")
    String email,
    @NotBlank (message = "O password não pode estar em branco!")
    String password
) {
  public User toEntity(String password) {
    return new User(
        null, role, email, password
    );
  }


}

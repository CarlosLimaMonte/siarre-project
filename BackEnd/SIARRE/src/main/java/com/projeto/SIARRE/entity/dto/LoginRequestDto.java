package com.projeto.SIARRE.entity.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginRequestDto(
    @NotBlank(message = "O email não pode ficar em branco!")
    @Email(message = "Insira um email válido!")
    String email,
    @NotBlank(message = "A senha não pode estar em branco!")
    String password
) {

}

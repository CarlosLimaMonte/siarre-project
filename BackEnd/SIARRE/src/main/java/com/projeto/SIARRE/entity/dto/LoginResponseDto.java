package com.projeto.SIARRE.entity.dto;

public record LoginResponseDto(
    String accessToken,
    String tokenType,
    long expiresIn
) {

}

package com.projeto.SIARRE.controller;

import com.projeto.SIARRE.entity.User;
import com.projeto.SIARRE.entity.dto.LoginRequestDto;
import com.projeto.SIARRE.entity.dto.LoginResponseDto;
import com.projeto.SIARRE.entity.dto.UserCreateDto;
import com.projeto.SIARRE.entity.dto.UserDto;
import com.projeto.SIARRE.service.TokenService;
import com.projeto.SIARRE.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

  private final AuthenticationManager authenticationManager;
  private final TokenService tokenService;
  private final UserService userService;

  public AuthController(AuthenticationManager authenticationManager, TokenService tokenService,
      UserService userService) {
    this.authenticationManager = authenticationManager;
    this.tokenService = tokenService;
    this.userService = userService;
  }

  @PostMapping("/login")
  public ResponseEntity<LoginResponseDto> login(@Valid @RequestBody LoginRequestDto loginRequestDto){
    Authentication authentication = authenticationManager.authenticate(
        UsernamePasswordAuthenticationToken.unauthenticated(
            loginRequestDto.email(),
            loginRequestDto.password()
        )
    );

    User user = (User) authentication.getPrincipal();

    String token = tokenService.generateJwt(user);

    LoginResponseDto responseDto = new LoginResponseDto(
        token,
        "Bearer",
        7200L
    );

    return ResponseEntity.status(HttpStatus.OK).body(responseDto);

  }

  @PostMapping("/register")
  public ResponseEntity<UserDto> register(@Valid @RequestBody UserCreateDto createDto){

     UserDto userHolder = userService.createUser(createDto);

     return ResponseEntity.status(HttpStatus.CREATED).body(userHolder);

  }


}

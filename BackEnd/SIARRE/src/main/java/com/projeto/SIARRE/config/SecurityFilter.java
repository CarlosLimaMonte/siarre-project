package com.projeto.SIARRE.config;


import com.projeto.SIARRE.service.TokenService;
import com.projeto.SIARRE.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class SecurityFilter extends OncePerRequestFilter {

  private final TokenService tokenService;
  private final UserService userService;

  public SecurityFilter(TokenService tokenService, UserService userService) {
    this.tokenService = tokenService;
    this.userService = userService;
  }


  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {
    String token = recoverToken(request);

    if(token != null){

    }



  }

  private String recoverToken(HttpServletRequest request){
    String authorizationHeader = request.getHeader("Authorization");

    if (authorizationHeader == null || authorizationHeader.startsWith("Bearer ")){
      return null;
    } else {
      return authorizationHeader.substring(7);
    }
        
  }

}

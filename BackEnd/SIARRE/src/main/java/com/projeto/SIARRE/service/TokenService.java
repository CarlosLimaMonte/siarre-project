package com.projeto.SIARRE.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.projeto.SIARRE.entity.User;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

  @Value("${api.security.token.secret}") String secret;
  @Value("${api.security.token.issuer}") String issuer;

  public String generateJwt(
      User user)
  {

    Algorithm algorithm = Algorithm.HMAC256(secret);

    return JWT.create()
        .withIssuer(issuer)
        .withSubject(user.getEmail())
        .withIssuedAt(Instant.now())
        .withExpiresAt(
            Instant.now().plus(2, ChronoUnit.HOURS)
        )
        .sign(algorithm);
  }


  public String validateToken(String token){
    try {
      Algorithm algorithm = Algorithm.HMAC256(secret);

      return JWT.require(algorithm)
          .withIssuer(issuer)
          .build()
          .verify(token)
          .getSubject();
    }catch (JWTVerificationException exception){
      return null;
    }

  }



}

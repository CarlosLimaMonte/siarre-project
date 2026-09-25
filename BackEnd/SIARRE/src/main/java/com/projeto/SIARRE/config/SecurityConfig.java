package com.projeto.SIARRE.config;

import com.projeto.SIARRE.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

  @Bean
  public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }

  @Bean
  public AuthenticationManager authenticationManager(
      DaoAuthenticationProvider daoAuthenticationProvider
  ) {
    return new ProviderManager(daoAuthenticationProvider);
  }

  @Bean
  public AuthenticationProvider authenticationProvider(UserService userService,
      PasswordEncoder passwordEncoder){

    DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userService);

    provider.setPasswordEncoder(passwordEncoder);

    return provider;
  }

  @Bean
  public SecurityFilterChain securityFilterChain(
      HttpSecurity http,
      DaoAuthenticationProvider authenticationProvider
  ){
    http
        .csrf(AbstractHttpConfigurer::disable)
        .sessionManagement(session -> session.sessionCreationPolicy(
            SessionCreationPolicy.STATELESS
        ))
        .formLogin(AbstractHttpConfigurer::disable)
        .httpBasic(AbstractHttpConfigurer::disable)
        .logout(AbstractHttpConfigurer::disable)
        .requestCache(AbstractHttpConfigurer::disable)
        .authenticationProvider(authenticationProvider)
        .authorizeHttpRequests(authorize -> authorize
            .requestMatchers("/auth/**")
              .permitAll()
            .requestMatchers(HttpMethod.POST, "/question", "/question/**")
              .hasAnyRole("GERENTE", "OPERADOR")
            .requestMatchers(HttpMethod.GET, "/question", "/question/**")
              .authenticated()
            .requestMatchers(HttpMethod.POST, "/assessment", "/assessment/**")
              .authenticated()
        );

    return http.build();


  }

}

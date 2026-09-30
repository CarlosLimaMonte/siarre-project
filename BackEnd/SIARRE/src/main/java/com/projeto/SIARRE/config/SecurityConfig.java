package com.projeto.SIARRE.config;

import com.projeto.SIARRE.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
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
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

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
  public DaoAuthenticationProvider authenticationProvider(UserService userService,
      PasswordEncoder passwordEncoder){

    DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userService);

    provider.setPasswordEncoder(passwordEncoder);

    return provider;
  }

  @Bean
  public FilterRegistrationBean<SecurityFilter> securityFilterRegistration(
      SecurityFilter securityFilter
  ) {

    FilterRegistrationBean<SecurityFilter> registration =
        new FilterRegistrationBean<>(securityFilter);

    registration.setEnabled(false);

    return registration;
  }


  @Bean
  public SecurityFilterChain securityFilterChain(
      HttpSecurity http,
      DaoAuthenticationProvider authenticationProvider,
      SecurityFilter securityFilter
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
            .requestMatchers("/auth/login", "/auth/register")
              .permitAll()
            .requestMatchers(HttpMethod.POST, "/question", "/question/**")
              .hasAnyRole("GERENTE", "OPERADOR")
            .requestMatchers(HttpMethod.GET, "/question", "/question/**")
              .authenticated()
            .requestMatchers(HttpMethod.POST, "/assessment", "/assessment/**")
              .authenticated()
            .anyRequest().authenticated()
        )
        .exceptionHandling(exceptions -> exceptions
            .authenticationEntryPoint((request, response, exception) -> {
              response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
              response.setHeader("WWW-Authenticate", "Bearer");
              response.setContentType("application/json");
              response.setCharacterEncoding("UTF-8");
              response.getWriter().write(
                  "{\"message\":\"É necessário estar autenticado para acessar este recurso.\"}"
              );
            })
            .accessDeniedHandler((request, response, exception) -> {
              response.setStatus(HttpServletResponse.SC_FORBIDDEN);
              response.setContentType("application/json");
              response.setCharacterEncoding("UTF-8");

              response.getWriter().write(
                  "{\"message\":\"Você não possui permissão para acessar este recurso.\"}"
              );
            })
        )
        .addFilterBefore(
            securityFilter,
            UsernamePasswordAuthenticationFilter.class
        );

    return http.build();


  }

}

package com.projeto.SIARRE.service;

import com.projeto.SIARRE.entity.User;
import com.projeto.SIARRE.entity.dto.UserCreateDto;
import com.projeto.SIARRE.entity.dto.UserDto;
import com.projeto.SIARRE.exception.UserAlreadyRegistered;
import com.projeto.SIARRE.exception.UserNotFoundException;
import com.projeto.SIARRE.repository.UserRepository;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

  private final UserRepository userRepository;
  private final BCryptPasswordEncoder bcryptPasswordEncoder;

  public UserService(UserRepository userRepository, BCryptPasswordEncoder bcryptPasswordEncoder) {
    this.userRepository = userRepository;
    this.bcryptPasswordEncoder = bcryptPasswordEncoder;
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    return userRepository.findByEmail(email).orElseThrow(
        () -> new UsernameNotFoundException("Usuário não encontrado!")
    );
  }

  // Create

  public UserDto createUser(UserCreateDto createUserDto) {

    if (userRepository.findByEmail(createUserDto.email()).isPresent()) {
      throw new UserAlreadyRegistered();
    }

    String password = bcryptPasswordEncoder.encode(createUserDto.password());

    return UserDto.fromEntity(userRepository.save(createUserDto.toEntity(password)));
  }

  // Read

  public User findUserById(Long id) {
    return userRepository.findById(id).orElseThrow(
        UserNotFoundException :: new
    );
  }

  // Read - All

  public List<UserDto> findAllUsers() {
    return userRepository.findAll().stream().map(UserDto::fromEntity).toList();
  }



}

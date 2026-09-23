package com.projeto.SIARRE.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.projeto.SIARRE.entity.Aggressor;
import com.projeto.SIARRE.exception.AggressorNotFoundException;
import com.projeto.SIARRE.repository.AggressorRepository;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AggressorServiceTest {

  @Mock
  private AggressorRepository aggressorRepository;

  @InjectMocks
  private AggressorService aggressorService;

  @Test
  void shouldFindAggressorById(){

    // Arrange

    Aggressor aggressor = new Aggressor();
    aggressor.setId(1L);
    aggressor.setName("João");

    when(aggressorRepository.findById(1L))
        .thenReturn(Optional.of(aggressor));

    // Act

    Aggressor result = aggressorService.findAggressorById(1L);

    // Assert

    assertNotNull(result);
    assertEquals(1L, result.getId());
    assertEquals("João", result.getName());

  }

  @Test
  void shouldThrowExceptionWhenAggressorDoesNotExist(){

    // Arrange

    when(aggressorRepository.findById(999L))
        .thenReturn(Optional.empty());

    // Act + Assert

    assertThrows(AggressorNotFoundException.class, () -> aggressorService.findAggressorById(999L));

  }


}

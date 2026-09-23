package com.projeto.SIARRE.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.projeto.SIARRE.entity.Victim;
import com.projeto.SIARRE.exception.VictimNotFoundException;
import com.projeto.SIARRE.repository.VictimRepository;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class VictimServiceTest {

  @Mock
  private VictimRepository victimRepository;

  @InjectMocks
  private VictimService victimService;

  @Test
  void shouldFindVictimById() {

    // Arrange

    Victim victim = new Victim();
    victim.setId(1L);
    victim.setName("Maria");

    when(victimRepository.findById(1L)).
        thenReturn(Optional.of(victim));

    // Act

    Victim result = victimService.findVictimById(1L);


    // Assert

    assertNotNull(result);
    assertEquals(1L, result.getId());
    assertEquals("Maria", result.getName());

  }

  @Test
  void shouldThrowExceptionWhenVictimDoesNotExist(){

    // Arrange

    when(victimRepository.findById(999L)).
        thenReturn(Optional.empty());

    assertThrows(VictimNotFoundException.class, () -> victimService.findVictimById(999L));


  }

}

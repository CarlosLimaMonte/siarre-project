package com.projeto.SIARRE.controller;


import com.projeto.SIARRE.entity.dto.VictimCreateDto;
import com.projeto.SIARRE.entity.dto.VictimResponseDto;
import com.projeto.SIARRE.service.VictimService;
import java.util.List;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/victim")
public class VictimController {

  private final VictimService victimService;

  public VictimController(VictimService victimService) {
    this.victimService = victimService;
  }

  // Create
  @PostMapping
  public ResponseEntity<VictimResponseDto> createVictim(@RequestBody VictimCreateDto victimCreateDto){

    VictimResponseDto newVictim = victimService.createVictim(victimCreateDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(newVictim);

  }

  // Read - All

  @GetMapping("/all")
  public List<VictimResponseDto> getAllVictims(){
    return victimService.findAllVictims();
  }

  // Read - By Id

  @GetMapping("/{id}")
  public VictimResponseDto getVictimById(@PathVariable Long id){
    return VictimResponseDto.fromEntity(victimService.findVictimById(id));
  }

  // Read - By Cpf

  @GetMapping("/search")
  public ResponseEntity<VictimResponseDto> getVictimByCpf(@RequestParam @CPF String cpf){

    return ResponseEntity.status(HttpStatus.OK).body(victimService.findVictimByCpf(cpf));
  }

  // Update - By Id

  @PutMapping("/{id}")
  public VictimResponseDto updateVictimById(@PathVariable Long id, @RequestBody VictimCreateDto victimCreateDto){
    return victimService.updateVictimById(id, victimCreateDto);
  }

  // Delete - By Id

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteVictimById(@PathVariable Long id){
    victimService.deleteVictimById(id);

    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

}

package com.projeto.SIARRE.controller;


import com.projeto.SIARRE.entity.dto.AggressorCreateDto;
import com.projeto.SIARRE.entity.dto.AggressorResponseDto;
import com.projeto.SIARRE.service.AggressorService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aggressor")
public class AggressorController {

  private final AggressorService aggressorService;

  public AggressorController(AggressorService aggressorService) {
    this.aggressorService = aggressorService;
  }

  // Create
  @PostMapping
  public ResponseEntity<AggressorResponseDto> createAggressor(@RequestBody AggressorCreateDto aggressorCreateDto){

    AggressorResponseDto newAggressor = aggressorService.createAggressor(aggressorCreateDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(newAggressor);

  }

  // Read - All

  @GetMapping("/all")
  public List<AggressorResponseDto> getAllAggressor(){
    return aggressorService.findAllAggressor();
  }

  // Read - By Id

  @GetMapping("/{id}")
  public AggressorResponseDto getAggressorById(@PathVariable Long id){
    return AggressorResponseDto.fromEntity(aggressorService.findAggressorById(id));
  }

  // Update - By Id

  @PutMapping("/{id}")
  public AggressorResponseDto updateAggressorById(@PathVariable Long id, AggressorCreateDto aggressorCreateDto){
    return aggressorService.updateAggressorById(id, aggressorCreateDto);
  }

  // Delete - By Id

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteAggressorById(@PathVariable Long id){
    aggressorService.deleteAggressorById(id);

    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

}

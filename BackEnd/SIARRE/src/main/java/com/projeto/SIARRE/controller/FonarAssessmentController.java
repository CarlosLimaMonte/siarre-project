package com.projeto.SIARRE.controller;

import com.projeto.SIARRE.entity.dto.FonarAssessmentCreateDto;
import com.projeto.SIARRE.entity.dto.FonarAssessmentDto;
import com.projeto.SIARRE.service.FonarAssessmentService;
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
@RequestMapping("/assessment")
public class FonarAssessmentController {

  private final FonarAssessmentService fonarAssessmentService;

  public FonarAssessmentController(FonarAssessmentService fonarAssessmentService) {
    this.fonarAssessmentService = fonarAssessmentService;
  }

  // Create

  @PostMapping
  public ResponseEntity<FonarAssessmentDto> createFonarAssessment(@RequestBody
      FonarAssessmentCreateDto assessmentCreateDto){

    FonarAssessmentDto assessmentDto = fonarAssessmentService.createFonarAssessment(assessmentCreateDto);

    return ResponseEntity.status(HttpStatus.CREATED).body(assessmentDto);
  }

  // Read - All

  @GetMapping
  public List<FonarAssessmentDto> getAllFonarAssessment(){
    return fonarAssessmentService.findAllFonarAssessment();
  }

  // Read - by Id

  @GetMapping("/{id}")
  public FonarAssessmentDto getFonarAssessmentById(@PathVariable Long id){
    return FonarAssessmentDto.fromEntity(fonarAssessmentService.findById(id));
  }

  // Read - By Victim Id

  @GetMapping("/victim/{id}")
  public List<FonarAssessmentDto> getFonarAssessmentByVictimId(@PathVariable Long victimId){
    return fonarAssessmentService.findByVictimId(victimId);
  }

  // Read - By Aggressor Id

  @GetMapping("/aggressor/{id}")
  public List<FonarAssessmentDto> getFonarAssessmentByAggressorId(@PathVariable Long aggressorId){
    return fonarAssessmentService.findByAggressorId(aggressorId);
  }

  // Update - By Id
  @PutMapping("/{id}")
  public FonarAssessmentDto updateFonarAssessment(@PathVariable Long id, @RequestBody FonarAssessmentCreateDto assessmentCreateDto){
    return fonarAssessmentService.updateFonarAssessment(id, assessmentCreateDto);
  }

  // Delete - By Id

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteFonarAssessmentById(@PathVariable Long id){

    fonarAssessmentService.deleteById(id);

    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

}

package com.projeto.SIARRE.controller;


import com.projeto.SIARRE.entity.FonarAssessment;
import com.projeto.SIARRE.entity.dto.FonarAssessmentCreateDto;
import com.projeto.SIARRE.entity.dto.FonarAssessmentDto;
import com.projeto.SIARRE.service.FonarAssessmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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



}

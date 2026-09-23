package com.projeto.SIARRE.controller;


import com.projeto.SIARRE.entity.dto.FonarQuestionCreateDto;
import com.projeto.SIARRE.entity.dto.FonarQuestionDto;
import com.projeto.SIARRE.service.FonarQuestionService;
import jakarta.validation.Valid;
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
@RequestMapping("/question")
public class FonarQuestionController {

  private final FonarQuestionService fonarQuestionService;

  public FonarQuestionController(FonarQuestionService fonarQuestionService) {
    this.fonarQuestionService = fonarQuestionService;
  }

  // Create

  @PostMapping
  public ResponseEntity<FonarQuestionDto> createFonarQuestion(@Valid @RequestBody
      FonarQuestionCreateDto fonarQuestionCreateDto){

    FonarQuestionDto createdQuestion = fonarQuestionService.createFonarQuestion(fonarQuestionCreateDto);

    return ResponseEntity.status(HttpStatus.CREATED).body(createdQuestion);
  }

  // Read - All

  @GetMapping
  public List<FonarQuestionDto> getAllFonarQuestion(){
    return fonarQuestionService.findAllFonarQuestion();
  }

  // Read - By Id

  @GetMapping("/{id}")
  public FonarQuestionDto getFonarQuestionById(@PathVariable Long id){
    return FonarQuestionDto.fromEntity(fonarQuestionService.findFonarQuestionById(id));
  }

  // Update - By Id

  @PutMapping("/{id}")
  public FonarQuestionDto uptadeFonarQuestionById(@PathVariable Long id, @Valid @RequestBody FonarQuestionCreateDto fonarQuestionCreateDto){
    return fonarQuestionService.updateFonarQuestion(id, fonarQuestionCreateDto);
  }

  // Delete - By Id

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteFonarQuestionById(@PathVariable Long id){

    fonarQuestionService.deleteById(id);

    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }


}

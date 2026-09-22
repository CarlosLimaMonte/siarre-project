package com.projeto.SIARRE.controller;


import com.projeto.SIARRE.entity.dto.RelationshipVictimAggressorCreateDto;
import com.projeto.SIARRE.entity.dto.RelationshipVictimAggressorDto;
import com.projeto.SIARRE.service.RelationshipVictimAggressorService;
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
@RequestMapping("/relation")
public class RelationshipController {

  private final RelationshipVictimAggressorService relationshipService;


  public RelationshipController(RelationshipVictimAggressorService relationshipService) {
    this.relationshipService = relationshipService;
  }

  // Create

  @PostMapping
  public ResponseEntity<RelationshipVictimAggressorDto> createRelationship(@RequestBody
      RelationshipVictimAggressorCreateDto relationCreateDto){

    RelationshipVictimAggressorDto relationshipDto = relationshipService.createRelationship(relationCreateDto);

    return ResponseEntity.status(HttpStatus.CREATED).body(relationshipDto);

  }

  // Read - All

  @GetMapping
  public List<RelationshipVictimAggressorDto> getAllRelationships(){
    return relationshipService.findAllRelationships();
  }

  // Read - By Id

  @GetMapping("/{id}")
  public RelationshipVictimAggressorDto getRelationshipById(@PathVariable Long id){
    return RelationshipVictimAggressorDto.fromEntity(relationshipService.findRelationshipById(id));
  }

  // Read - By Victim Id

  @GetMapping("/victim/{victimId}")
  public List<RelationshipVictimAggressorDto> getRelationshipByVictimId(@PathVariable Long victimId){
    return relationshipService.findRelationshipByVictimId(victimId);
  }

  // Read - By Aggressor Id

  @GetMapping("/aggressor/{aggressorId}")
  public List<RelationshipVictimAggressorDto> getRelationshipByAggressorId(@PathVariable Long aggressorId){
    return relationshipService.findRelationshipByAggressorId(aggressorId);
  }

  // Update - By Id

  @PutMapping("/{id}")
  public RelationshipVictimAggressorDto updateRelationship(@PathVariable Long id, @RequestBody RelationshipVictimAggressorCreateDto relationCreateDto){
    return relationshipService.updateRelationship(id, relationCreateDto);
  }

  // Delete - By Id

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteRelationshipById(@PathVariable Long id){
    relationshipService.deleteRelationship(id);

    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }


}

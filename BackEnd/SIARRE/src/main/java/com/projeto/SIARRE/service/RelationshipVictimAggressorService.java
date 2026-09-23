package com.projeto.SIARRE.service;

import com.projeto.SIARRE.entity.Aggressor;
import com.projeto.SIARRE.entity.RelationshipVictimAggressor;
import com.projeto.SIARRE.entity.Victim;
import com.projeto.SIARRE.entity.dto.RelationshipVictimAggressorCreateDto;
import com.projeto.SIARRE.entity.dto.RelationshipVictimAggressorDto;
import com.projeto.SIARRE.exception.AggressorNotFoundException;
import com.projeto.SIARRE.exception.RelationshipAlreadyExistsException;
import com.projeto.SIARRE.exception.RelationshipVictimAggressorNotFoundException;
import com.projeto.SIARRE.exception.VictimNotFoundException;
import com.projeto.SIARRE.repository.AggressorRepository;
import com.projeto.SIARRE.repository.RelationshipVictimAggressorRepository;
import com.projeto.SIARRE.repository.VictimRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RelationshipVictimAggressorService {

  public final RelationshipVictimAggressorRepository relationshipRepository;
  public final VictimRepository victimRepository;
  public final AggressorRepository aggressorRepository;

  public RelationshipVictimAggressorService(
      RelationshipVictimAggressorRepository relationshipRepository,
      VictimRepository victimRepository, AggressorRepository aggressorRepository) {
    this.relationshipRepository = relationshipRepository;
    this.victimRepository = victimRepository;
    this.aggressorRepository = aggressorRepository;
  }

  // Create

  public RelationshipVictimAggressorDto createRelationship(RelationshipVictimAggressorCreateDto relationshipCreateDto){


    Victim victim = victimRepository.findById(relationshipCreateDto.victimId()).orElseThrow(
        VictimNotFoundException::new
    );

    Aggressor aggressor = aggressorRepository.findById(relationshipCreateDto.aggressorId()).orElseThrow(
        AggressorNotFoundException::new
    );

    if (relationshipRepository.existsByVictimIdAndAggressorId(victim.getId(), aggressor.getId())){
      throw new RelationshipAlreadyExistsException();
    }

    return RelationshipVictimAggressorDto.fromEntity(relationshipRepository.save(relationshipCreateDto.toEntity(victim, aggressor)));
  }

  // Read - All

  public List<RelationshipVictimAggressorDto> findAllRelationships(){
    return relationshipRepository.findAll().stream().map( RelationshipVictimAggressorDto :: fromEntity).toList();
  }

  // Read - By Id

  public RelationshipVictimAggressor findRelationshipById(Long id){
    return relationshipRepository.findById(id).orElseThrow(
        RelationshipVictimAggressorNotFoundException :: new
    );
  }

  // Read - By Victim Id

  public List<RelationshipVictimAggressorDto> findRelationshipByVictimId(Long id){
    return relationshipRepository.findByVictim_id(id).stream().map(RelationshipVictimAggressorDto :: fromEntity).toList();
  }

  // Read - By Aggressor Id

  public List<RelationshipVictimAggressorDto> findRelationshipByAggressorId(Long id){
    return relationshipRepository.findByAggressor_id(id).stream().map(RelationshipVictimAggressorDto :: fromEntity).toList();
  }

  // Update

  public RelationshipVictimAggressorDto updateRelationship (Long id, RelationshipVictimAggressorCreateDto relationshipCreateDto){

    RelationshipVictimAggressor relationshipFromDb = findRelationshipById(id);

    Victim victim = victimRepository.findById(relationshipCreateDto.victimId()).orElseThrow(
        VictimNotFoundException::new
    );

    Aggressor aggressor = aggressorRepository.findById(relationshipCreateDto.aggressorId()).orElseThrow(
        AggressorNotFoundException::new
    );

    relationshipFromDb.setVictim(victim);
    relationshipFromDb.setAggressor(aggressor);
    relationshipFromDb.setRomanticRelationship(relationshipCreateDto.romanticRelationship());
    relationshipFromDb.setFamilyRelationship(relationshipCreateDto.familyRelationship());
    relationshipFromDb.setDomesticRelationship(relationshipCreateDto.domesticRelationship());

    return RelationshipVictimAggressorDto.fromEntity(relationshipRepository.save(relationshipFromDb));
  }

  // Delete

  public void deleteRelationship(Long id){

    RelationshipVictimAggressor relationshipVictimAggressor = findRelationshipById(id);

    relationshipRepository.deleteById(id);
  }


}

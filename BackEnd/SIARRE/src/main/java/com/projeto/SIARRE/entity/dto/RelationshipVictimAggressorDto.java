package com.projeto.SIARRE.entity.dto;

import com.projeto.SIARRE.entity.RelationshipVictimAggressor;
import com.projeto.SIARRE.enumClass.DomesticRelationship;
import com.projeto.SIARRE.enumClass.FamilyRelationship;
import com.projeto.SIARRE.enumClass.RomanticRelationship;

public record RelationshipVictimAggressorDto (
    Long id,
    Long victimId,
    Long aggressorId,
    RomanticRelationship romanticRelationship,
    FamilyRelationship familyRelationship,
    DomesticRelationship domesticRelationship
){

  public static RelationshipVictimAggressorDto fromEntity(RelationshipVictimAggressor entity){
    return new RelationshipVictimAggressorDto(
        entity.getId(),
        entity.getVictim().getId(),
        entity.getAggressor().getId(),
        entity.getRomanticRelationship(),
        entity.getFamilyRelationship(),
        entity.getDomesticRelationship()
    );
  }

}

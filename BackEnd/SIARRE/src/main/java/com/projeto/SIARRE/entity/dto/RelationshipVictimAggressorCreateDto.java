package com.projeto.SIARRE.entity.dto;

import com.projeto.SIARRE.entity.Aggressor;
import com.projeto.SIARRE.entity.RelationshipVictimAggressor;
import com.projeto.SIARRE.entity.Victim;
import com.projeto.SIARRE.enumClass.DomesticRelationship;
import com.projeto.SIARRE.enumClass.FamilyRelationship;
import com.projeto.SIARRE.enumClass.RomanticRelationship;

public record RelationshipVictimAggressorCreateDto(
    Long victimId,
    Long aggressorId,
    RomanticRelationship romanticRelationship,
    FamilyRelationship familyRelationship,
    DomesticRelationship domesticRelationship
) {

  public RelationshipVictimAggressor toEntity(Victim victim, Aggressor aggressor) {
    return new RelationshipVictimAggressor(null, victim, aggressor, romanticRelationship, familyRelationship, domesticRelationship);
  }


}

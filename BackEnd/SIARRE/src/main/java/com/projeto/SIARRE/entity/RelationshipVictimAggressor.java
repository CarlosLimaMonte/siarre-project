package com.projeto.SIARRE.entity;

import com.projeto.SIARRE.enumClass.DomesticRelationship;
import com.projeto.SIARRE.enumClass.FamilyRelationship;
import com.projeto.SIARRE.enumClass.RomanticRelationship;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "RelationshipVictimAggressor")
public class RelationshipVictimAggressor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "victim_id")
  private Victim victim;

  @ManyToOne
  @JoinColumn(name = "aggressor_id")
  private Aggressor aggressor;

  private RomanticRelationship romanticRelationship;

  private FamilyRelationship familyRelationship;

  private DomesticRelationship domesticRelationship;

}

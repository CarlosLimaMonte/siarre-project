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

  public RelationshipVictimAggressor() {
  }

  public RelationshipVictimAggressor(Long id, Victim victim, Aggressor aggressor,
      RomanticRelationship romanticRelationship, FamilyRelationship familyRelationship,
      DomesticRelationship domesticRelationship) {
    this.id = id;
    this.victim = victim;
    this.aggressor = aggressor;
    this.romanticRelationship = romanticRelationship;
    this.familyRelationship = familyRelationship;
    this.domesticRelationship = domesticRelationship;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Victim getVictim() {
    return victim;
  }

  public void setVictim(Victim victim) {
    this.victim = victim;
  }

  public Aggressor getAggressor() {
    return aggressor;
  }

  public void setAggressor(Aggressor aggressor) {
    this.aggressor = aggressor;
  }

  public RomanticRelationship getRomanticRelationship() {
    return romanticRelationship;
  }

  public void setRomanticRelationship(
      RomanticRelationship romanticRelationship) {
    this.romanticRelationship = romanticRelationship;
  }

  public FamilyRelationship getFamilyRelationship() {
    return familyRelationship;
  }

  public void setFamilyRelationship(FamilyRelationship familyRelationship) {
    this.familyRelationship = familyRelationship;
  }

  public DomesticRelationship getDomesticRelationship() {
    return domesticRelationship;
  }

  public void setDomesticRelationship(
      DomesticRelationship domesticRelationship) {
    this.domesticRelationship = domesticRelationship;
  }
}

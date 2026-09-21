package com.projeto.SIARRE.entity;

import com.projeto.SIARRE.enumClass.Education;
import com.projeto.SIARRE.enumClass.GenderIdentity;
import com.projeto.SIARRE.enumClass.Nationality;
import com.projeto.SIARRE.enumClass.SexualOrientation;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "victim")
public class Victim {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private String socialName;

  @CPF
  private String cpf;

  private LocalDate dateOfBirth;

  @Enumerated(EnumType.STRING)
  private GenderIdentity genderIdentity;

  @Enumerated(EnumType.STRING)
  private SexualOrientation sexualOrientation;

  @Enumerated(EnumType.STRING)
  private Education education;

  @Enumerated(EnumType.STRING)
  private Nationality nationality;

  @OneToMany(mappedBy = "victim")
  private List<RelationshipVictimAggressor> relationshipVictimAggressorList;

  @OneToMany(mappedBy = "victim")
  private List<FonarAssessment> fonarAssessmentList;

  public Victim() {
  }

  public Victim(Long id, String name, String socialName, String cpf, LocalDate dateOfBirth,
      GenderIdentity genderIdentity, SexualOrientation sexualOrientation, Education education,
      Nationality nationality, List<RelationshipVictimAggressor> relationshipVictimAggressorList,
      List<FonarAssessment> fonarAssessmentList) {
    this.id = id;
    this.name = name;
    this.socialName = socialName;
    this.cpf = cpf;
    this.dateOfBirth = dateOfBirth;
    this.genderIdentity = genderIdentity;
    this.sexualOrientation = sexualOrientation;
    this.education = education;
    this.nationality = nationality;
    this.relationshipVictimAggressorList = relationshipVictimAggressorList;
    this.fonarAssessmentList = fonarAssessmentList;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSocialName() {
    return socialName;
  }

  public void setSocialName(String socialName) {
    this.socialName = socialName;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public GenderIdentity getGenderIdentity() {
    return genderIdentity;
  }

  public void setGenderIdentity(GenderIdentity genderIdentity) {
    this.genderIdentity = genderIdentity;
  }

  public SexualOrientation getSexualOrientation() {
    return sexualOrientation;
  }

  public void setSexualOrientation(SexualOrientation sexualOrientation) {
    this.sexualOrientation = sexualOrientation;
  }

  public Education getEducation() {
    return education;
  }

  public void setEducation(Education education) {
    this.education = education;
  }

  public Nationality getNationality() {
    return nationality;
  }

  public void setNationality(Nationality nationality) {
    this.nationality = nationality;
  }

  public List<RelationshipVictimAggressor> getRelationshipVictimAggressorList() {
    return relationshipVictimAggressorList;
  }

  public void setRelationshipVictimAggressorList(
      List<RelationshipVictimAggressor> relationshipVictimAggressorList) {
    this.relationshipVictimAggressorList = relationshipVictimAggressorList;
  }

  public List<FonarAssessment> getFonarAssessmentList() {
    return fonarAssessmentList;
  }

  public void setFonarAssessmentList(
      List<FonarAssessment> fonarAssessmentList) {
    this.fonarAssessmentList = fonarAssessmentList;
  }
}

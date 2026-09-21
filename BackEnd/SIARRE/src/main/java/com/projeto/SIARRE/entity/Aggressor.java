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

@Entity
@Table(name = "aggressor")
public class Aggressor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private String socialName;

  private LocalDate dateOfBirth;

  private Integer age;

  @Enumerated(EnumType.STRING)
  private GenderIdentity genderIdentity;

  @Enumerated(EnumType.STRING)
  private SexualOrientation sexualOrientation;

  @Enumerated(EnumType.STRING)
  private Education education;

  @Enumerated(EnumType.STRING)
  private Nationality nationality;

  @OneToMany(mappedBy = "aggressor")
  private List<RelationshipVictimAggressor> relationshipVictimAggressorList;

  public Aggressor() {
  }

  public Aggressor(Long id, String name, String socialName, LocalDate dateOfBirth, Integer age,
      GenderIdentity genderIdentity, SexualOrientation sexualOrientation, Education education,
      Nationality nationality) {
    this.id = id;
    this.name = name;
    this.socialName = socialName;
    this.dateOfBirth = dateOfBirth;
    this.age = age;
    this.genderIdentity = genderIdentity;
    this.sexualOrientation = sexualOrientation;
    this.education = education;
    this.nationality = nationality;
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

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
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
}

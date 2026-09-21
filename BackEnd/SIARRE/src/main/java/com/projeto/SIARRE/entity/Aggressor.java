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

}

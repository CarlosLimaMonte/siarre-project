package com.projeto.SIARRE.entity;

import com.projeto.SIARRE.enumClass.Education;
import com.projeto.SIARRE.enumClass.GenderIdentity;
import com.projeto.SIARRE.enumClass.Nationality;
import com.projeto.SIARRE.enumClass.SexualOrientation;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import org.hibernate.validator.constraints.br.CPF;

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

  private GenderIdentity genderIdentity;

  private SexualOrientation sexualOrientation;

  private Education education;

  private Nationality nationality;

  @OneToMany
  private List<RelationshipVictimAggressor> relationshipVictimAggressorList;

}

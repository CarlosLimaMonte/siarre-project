package com.projeto.SIARRE.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "fonaranswer")
public class FonarAnswer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "question_id")
  private FonarQuestion question;

  @ManyToOne
  @JoinColumn(name = "assessment_id")
  private FonarAssessment fonarAssessment;

  @ManyToOne
  @JoinColumn(name = "option_id")
  private FonarOption fonarOption;

}

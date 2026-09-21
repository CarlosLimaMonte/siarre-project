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

  public FonarAnswer() {
  }

  public FonarAnswer(Long id, FonarQuestion question, FonarAssessment fonarAssessment,
      FonarOption fonarOption) {
    this.id = id;
    this.question = question;
    this.fonarAssessment = fonarAssessment;
    this.fonarOption = fonarOption;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public FonarQuestion getQuestion() {
    return question;
  }

  public void setQuestion(FonarQuestion question) {
    this.question = question;
  }

  public FonarAssessment getFonarAssessment() {
    return fonarAssessment;
  }

  public void setFonarAssessment(FonarAssessment fonarAssessment) {
    this.fonarAssessment = fonarAssessment;
  }

  public FonarOption getFonarOption() {
    return fonarOption;
  }

  public void setFonarOption(FonarOption fonarOption) {
    this.fonarOption = fonarOption;
  }
}

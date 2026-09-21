package com.projeto.SIARRE.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "fonaroption")
public class FonarOption {

  @Id
  private Long id;

  @ManyToOne
  @JoinColumn(name = "question_id")
  private FonarQuestion question;

  private String label;

  private String value;

  public FonarOption() {
  }

  public FonarOption(Long id, FonarQuestion question, String label, String value) {
    this.id = id;
    this.question = question;
    this.label = label;
    this.value = value;
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

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}

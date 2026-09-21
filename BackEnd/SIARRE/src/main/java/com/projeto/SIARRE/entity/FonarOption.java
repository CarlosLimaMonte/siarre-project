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

}

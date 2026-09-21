package com.projeto.SIARRE.entity;

import com.projeto.SIARRE.enumClass.RiskLevel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "assessment")
public class AssessmentFONAR {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "victim_id")
  private Victim victim;

  @ManyToOne
  @JoinColumn(name = "aggressor_id")
  private Aggressor aggressor;

  private Integer score;

  @ManyToOne
  @JoinColumn(name = "professionalValidatedBy_id")
  private User professionalValidatedBy;

  private LocalDateTime createdDate;

  private RiskLevel suggestedRiskLevel;

  private RiskLevel validatedRiskLevel;

  private LocalDateTime validatedIn;

}

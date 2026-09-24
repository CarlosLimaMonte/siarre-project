package com.projeto.SIARRE.entity;

import com.projeto.SIARRE.enumClass.RiskLevel;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "assessment")
public class FonarAssessment {
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

  @CreationTimestamp
  private LocalDateTime createdDate;

  @Enumerated(EnumType.STRING)
  private RiskLevel suggestedRiskLevel;

  @Enumerated(EnumType.STRING)
  private RiskLevel validatedRiskLevel;

  private LocalDateTime validatedIn;

  @OneToMany(mappedBy = "fonarAssessment")
  private List<FonarAnswer> fonarAnswerList;

  public FonarAssessment() {
  }

  public FonarAssessment(Long id, Victim victim, Aggressor aggressor, Integer score,
      User professionalValidatedBy, RiskLevel suggestedRiskLevel,
      RiskLevel validatedRiskLevel, LocalDateTime validatedIn, List<FonarAnswer> fonarAnswerList) {
    this.id = id;
    this.victim = victim;
    this.aggressor = aggressor;
    this.score = score;
    this.professionalValidatedBy = professionalValidatedBy;
    this.suggestedRiskLevel = suggestedRiskLevel;
    this.validatedRiskLevel = validatedRiskLevel;
    this.validatedIn = validatedIn;
    this.fonarAnswerList = fonarAnswerList;
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

  public Integer getScore() {
    return score;
  }

  public void setScore(Integer score) {
    this.score = score;
  }

  public User getProfessionalValidatedBy() {
    return professionalValidatedBy;
  }

  public void setProfessionalValidatedBy(User professionalValidatedBy) {
    this.professionalValidatedBy = professionalValidatedBy;
  }

  public LocalDateTime getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(LocalDateTime createdDate) {
    this.createdDate = createdDate;
  }

  public RiskLevel getSuggestedRiskLevel() {
    return suggestedRiskLevel;
  }

  public void setSuggestedRiskLevel(RiskLevel suggestedRiskLevel) {
    this.suggestedRiskLevel = suggestedRiskLevel;
  }

  public RiskLevel getValidatedRiskLevel() {
    return validatedRiskLevel;
  }

  public void setValidatedRiskLevel(RiskLevel validatedRiskLevel) {
    this.validatedRiskLevel = validatedRiskLevel;
  }

  public LocalDateTime getValidatedIn() {
    return validatedIn;
  }

  public void setValidatedIn(LocalDateTime validatedIn) {
    this.validatedIn = validatedIn;
  }

  public List<FonarAnswer> getFonarAnswerList() {
    return fonarAnswerList;
  }

  public void setFonarAnswerList(List<FonarAnswer> fonarAnswerList) {
    this.fonarAnswerList = fonarAnswerList;
  }
}

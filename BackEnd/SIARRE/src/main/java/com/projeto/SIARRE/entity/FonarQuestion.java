package com.projeto.SIARRE.entity;

import com.projeto.SIARRE.enumClass.TypeQuestion;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "fonarquestion")
public class FonarQuestion {

  @Id
  private Long id;

  private String texto;

  @Enumerated(EnumType.STRING)
  private TypeQuestion typeQuestion;

  @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
  private List<FonarOption> optionsList;

  private Boolean required;

  public FonarQuestion() {
  }

  public FonarQuestion(Long id, String texto, TypeQuestion typeQuestion,
      List<FonarOption> optionsList, Boolean required) {
    this.id = id;
    this.texto = texto;
    this.typeQuestion = typeQuestion;
    this.optionsList = optionsList;
    this.required = required;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTexto() {
    return texto;
  }

  public void setTexto(String texto) {
    this.texto = texto;
  }

  public TypeQuestion getTypeQuestion() {
    return typeQuestion;
  }

  public void setTypeQuestion(TypeQuestion typeQuestion) {
    this.typeQuestion = typeQuestion;
  }

  public List<FonarOption> getOptionsList() {
    return optionsList;
  }

  public void setOptionsList(List<FonarOption> optionsList) {
    this.optionsList = optionsList;
  }

  public Boolean getRequired() {
    return required;
  }

  public void setRequired(Boolean required) {
    this.required = required;
  }
}

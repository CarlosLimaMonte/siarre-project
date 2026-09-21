package com.projeto.SIARRE.entity;

import com.projeto.SIARRE.enumClass.TypeQuestion;
import jakarta.persistence.Entity;
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

  private TypeQuestion typeQuestion;

  @OneToMany(mappedBy = "question")
  private List<FonarOption> optionsList;

  public FonarQuestion() {
  }

  public FonarQuestion(Long id, String texto, TypeQuestion typeQuestion,
      List<FonarOption> optionsList) {
    this.id = id;
    this.texto = texto;
    this.typeQuestion = typeQuestion;
    this.optionsList = optionsList;
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
}

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


}

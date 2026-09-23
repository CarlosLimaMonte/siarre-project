package com.projeto.SIARRE.service;

import com.projeto.SIARRE.entity.FonarOption;
import com.projeto.SIARRE.entity.FonarQuestion;
import com.projeto.SIARRE.entity.dto.FonarQuestionCreateDto;
import com.projeto.SIARRE.entity.dto.FonarQuestionDto;
import com.projeto.SIARRE.exception.FonarQuestionNotFoundException;
import com.projeto.SIARRE.repository.FonarOptionRepository;
import com.projeto.SIARRE.repository.FonarQuestionRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FonarQuestionService {

  private final FonarQuestionRepository fonarQuestionRepository;

  private final FonarOptionRepository fonarOptionRepository;

  public FonarQuestionService(FonarQuestionRepository fonarQuestionRepository,
      FonarOptionRepository fonarOptionRepository) {
    this.fonarQuestionRepository = fonarQuestionRepository;
    this.fonarOptionRepository = fonarOptionRepository;
  }

  // Create

  public FonarQuestionDto createFonarQuestion(FonarQuestionCreateDto fonarQuestionCreateDto){

    FonarQuestion fonarQuestion = new FonarQuestion();

    fonarQuestion.setId(null);
    fonarQuestion.setTexto(fonarQuestionCreateDto.texto());
    fonarQuestion.setTypeQuestion(fonarQuestionCreateDto.typeQuestion());
    fonarQuestion.setRequired(fonarQuestionCreateDto.required());

    List<FonarOption> options = fonarQuestionCreateDto.optionIds().stream()
            .map(optionDto -> {

              FonarOption fonarOption = new FonarOption();

              fonarOption.setLabel(optionDto.label());
              fonarOption.setValue(optionDto.value());
              fonarOption.setScore(optionDto.score());
              fonarOption.setQuestion(fonarQuestion);

              return fonarOption;

            })
            .toList();

    fonarQuestion.setOptionsList(options);

    return FonarQuestionDto.fromEntity(fonarQuestionRepository.save(fonarQuestion));

  }

  // Read - Find all

  public List<FonarQuestionDto> findAllFonarQuestion(){
    return fonarQuestionRepository.findAll().stream().map(FonarQuestionDto :: fromEntity).toList();
  }

  // Read - Find By Id

  public FonarQuestion findFonarQuestionById(Long id){
    return fonarQuestionRepository.findById(id).orElseThrow(
        FonarQuestionNotFoundException :: new
    );
  }

  // Update - By Id

  public FonarQuestionDto updateFonarQuestion(Long id, FonarQuestionCreateDto fonarQuestionCreateDto){

    FonarQuestion fonarQuestionDb = findFonarQuestionById(id);

    List<FonarOption> fonarOptionList = fonarQuestionCreateDto.optionIds().stream()
              .map(optionDto -> {

                FonarOption fonarOption = new FonarOption();

                fonarOption.setLabel(optionDto.label());
                fonarOption.setValue(optionDto.value());
                fonarOption.setScore(optionDto.score());

                fonarOption.setQuestion(fonarQuestionDb);

                return fonarOption;

              })
              .toList();


    fonarQuestionDb.setTexto(fonarQuestionCreateDto.texto());
    fonarQuestionDb.setTypeQuestion(fonarQuestionCreateDto.typeQuestion());
    fonarQuestionDb.setOptionsList(fonarOptionList);
    fonarQuestionDb.setRequired(fonarQuestionCreateDto.required());

    return FonarQuestionDto.fromEntity(fonarQuestionRepository.save(fonarQuestionDb));
  }

  // Delete - By Id

  public void deleteById(Long id){

    FonarQuestion fonarQuestion = findFonarQuestionById(id);

    fonarOptionRepository.deleteById(id);
  }


}

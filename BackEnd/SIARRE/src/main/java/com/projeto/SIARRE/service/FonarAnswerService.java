package com.projeto.SIARRE.service;



import com.projeto.SIARRE.entity.FonarAnswer;
import com.projeto.SIARRE.entity.FonarAssessment;
import com.projeto.SIARRE.entity.FonarOption;
import com.projeto.SIARRE.entity.FonarQuestion;
import com.projeto.SIARRE.entity.dto.FonarAnswerCreateDto;
import com.projeto.SIARRE.entity.dto.FonarAnswerDto;
import com.projeto.SIARRE.exception.FonarAnswerNotFoundException;
import com.projeto.SIARRE.exception.FonarAssessmentNotFoundException;
import com.projeto.SIARRE.exception.FonarOptionNotFoundException;
import com.projeto.SIARRE.exception.FonarQuestionNotFoundException;
import com.projeto.SIARRE.exception.OptionDoesntBelongThisQuestionException;
import com.projeto.SIARRE.repository.FonarAnswerRepository;
import com.projeto.SIARRE.repository.FonarAssessmentRepository;
import com.projeto.SIARRE.repository.FonarOptionRepository;
import com.projeto.SIARRE.repository.FonarQuestionRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FonarAnswerService {

  public final FonarAnswerRepository fonarAnswerRepository;
  public final FonarQuestionRepository fonarQuestionRepository;
  public final FonarAssessmentRepository fonarAssessmentRepository;
  public final FonarOptionRepository fonarOptionRepository;

  public FonarAnswerService(FonarAnswerRepository fonarAnswerRepository,
      FonarQuestionRepository fonarQuestionRepository,
      FonarAssessmentRepository fonarAssessmentRepository, FonarOptionRepository fonarOptionRepository) {
    this.fonarAnswerRepository = fonarAnswerRepository;
    this.fonarQuestionRepository = fonarQuestionRepository;
    this.fonarAssessmentRepository = fonarAssessmentRepository;
    this.fonarOptionRepository = fonarOptionRepository;
  }

  // Create

  public FonarAnswer createFonarAnswer(FonarAssessment assessment  ,FonarAnswerCreateDto fonarAnswerCreateDto){

    FonarQuestion question = fonarQuestionRepository.findById(fonarAnswerCreateDto.questionId()).orElseThrow(
        FonarQuestionNotFoundException :: new
    );

    FonarOption option = fonarOptionRepository.findById(fonarAnswerCreateDto.optionId()).orElseThrow(
        FonarOptionNotFoundException :: new
    );

    if(question.equals(option.getQuestion())){
      return fonarAnswerRepository.save(fonarAnswerCreateDto.toEntity(question, assessment ,option));
    }

    throw new OptionDoesntBelongThisQuestionException();

  }

  // Read - All

  public List<FonarAnswerDto> findAllFonarAnswer(){
    return fonarAnswerRepository.findAll().stream().map(FonarAnswerDto :: fromEntity).toList();
  }

  // Read - By Id

  public FonarAnswer findFonarAnswerById(Long id){
    return fonarAnswerRepository.findById(id).orElseThrow(FonarAnswerNotFoundException::new);
  }

  // Read - All Answer By Assement

  public List<FonarAnswerDto> findFonarAnswerByAssessment(Long assessmentId){
     return fonarAnswerRepository.findByAssessment_id(assessmentId).stream().map(FonarAnswerDto :: fromEntity).toList();
  }

  // Update - By Id

  public FonarAnswerDto updateFonarAnswer(Long id, FonarAssessment assessment ,FonarAnswerCreateDto fonarAnswerCreateDto){

    FonarAnswer answerFromDb = findFonarAnswerById(id);

    FonarQuestion question = fonarQuestionRepository.findById(fonarAnswerCreateDto.questionId()).orElseThrow(
        FonarQuestionNotFoundException :: new
    );

    FonarOption option = fonarOptionRepository.findById(fonarAnswerCreateDto.optionId()).orElseThrow(
        FonarOptionNotFoundException :: new
    );

    if(question.equals(option.getQuestion())){

      answerFromDb.setQuestion(question);
      answerFromDb.setFonarAssessment(assessment);
      answerFromDb.setFonarOption(option);

      return FonarAnswerDto.fromEntity(fonarAnswerRepository.save(answerFromDb));
    }

    throw new OptionDoesntBelongThisQuestionException();

  }

  // Delete

  public void deleteFonarAnswer(Long id){

    FonarAnswer fonarAnswer = findFonarAnswerById(id);

    fonarAnswerRepository.deleteById(id);

  }

}

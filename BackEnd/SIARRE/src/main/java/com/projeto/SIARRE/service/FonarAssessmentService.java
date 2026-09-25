package com.projeto.SIARRE.service;

import com.projeto.SIARRE.entity.Aggressor;
import com.projeto.SIARRE.entity.FonarAnswer;
import com.projeto.SIARRE.entity.FonarAssessment;
import com.projeto.SIARRE.entity.Victim;
import com.projeto.SIARRE.entity.dto.FonarAnswerCreateDto;
import com.projeto.SIARRE.entity.dto.FonarAnswerDto;
import com.projeto.SIARRE.entity.dto.FonarAssessmentCreateDto;
import com.projeto.SIARRE.entity.dto.FonarAssessmentDto;
import com.projeto.SIARRE.exception.AggressorNotFoundException;
import com.projeto.SIARRE.exception.FonarAssessmentNotFoundException;
import com.projeto.SIARRE.exception.NoAnswerWasFilledException;
import com.projeto.SIARRE.exception.VictimNotFoundException;
import com.projeto.SIARRE.repository.AggressorRepository;
import com.projeto.SIARRE.repository.FonarAssessmentRepository;
import com.projeto.SIARRE.repository.VictimRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FonarAssessmentService {

  private final FonarAssessmentRepository fonarAssessmentRepository;
  private final FonarAnswerService fonarAnswerService;
  private final VictimRepository victimRepository;
  private final AggressorRepository aggressorRepository;

  public FonarAssessmentService(FonarAssessmentRepository fonarAssessmentRepository,
      FonarAnswerService fonarAnswerService,
      VictimRepository victimRepository, AggressorRepository aggressorRepository) {
    this.fonarAssessmentRepository = fonarAssessmentRepository;
    this.fonarAnswerService = fonarAnswerService;
    this.victimRepository = victimRepository;
    this.aggressorRepository = aggressorRepository;
  }

  // Create

  public FonarAssessmentDto createFonarAssessment(FonarAssessmentCreateDto assessmentCreateDto){

    Victim victim = victimRepository.findById(assessmentCreateDto.victimId()).orElseThrow(
        VictimNotFoundException::new
    );

    Aggressor aggressor = aggressorRepository.findById(assessmentCreateDto.aggressorId()).orElseThrow(
        AggressorNotFoundException::new
    );

    return FonarAssessmentDto.fromEntity(fonarAssessmentRepository.save(assessmentCreateDto.toEntity(victim, aggressor)));

  }

  // Read - All

  public List<FonarAssessmentDto> findAllFonarAssessment(){
    return fonarAssessmentRepository.findAll().stream().map(
        FonarAssessmentDto :: fromEntity
    ).toList();
  }

  // Read - Find by Id

  public FonarAssessment findById(Long id){
    return fonarAssessmentRepository.findById(id).orElseThrow(
        FonarAssessmentNotFoundException :: new
    );
  }

  // Read - Find By Victim Id

  public List<FonarAssessmentDto> findByVictimId(Long victimId){
    return fonarAssessmentRepository.findByVictim_id(victimId).stream().map(
        FonarAssessmentDto::fromEntity
    ).toList();
  }

  // Read - Find by Aggressor Id


  public List<FonarAssessmentDto> findByAggressorId(Long aggressorId){
    return fonarAssessmentRepository.findByAggressor_id(aggressorId).stream().map(
        FonarAssessmentDto::fromEntity
    ).toList();
  }

  // Update - By Id

  public FonarAssessmentDto updateFonarAssessment(Long id, FonarAssessmentCreateDto assessmentCreateDto){

    FonarAssessment assessmentFromDb = findById(id);

    Victim victim = victimRepository.findById(assessmentCreateDto.victimId()).orElseThrow(
        VictimNotFoundException::new
    );

    Aggressor aggressor = aggressorRepository.findById(assessmentCreateDto.aggressorId()).orElseThrow(
        AggressorNotFoundException::new
    );

    assessmentFromDb.setVictim(victim);
    assessmentFromDb.setAggressor(aggressor);

    return FonarAssessmentDto.fromEntity(fonarAssessmentRepository.save(assessmentFromDb));

  }

  // Delete - By Id

  public void deleteById(Long id){
    FonarAssessment assessment = findById(id);

    fonarAssessmentRepository.deleteById(id);

  }

  // Receive answer

  public FonarAnswerDto receiveAndAddAnswer(Long assessmentId, FonarAnswerCreateDto answerCreateDto){

    FonarAssessment assessment = findById(assessmentId);

    FonarAnswer answer = fonarAnswerService.createFonarAnswer(assessment, answerCreateDto);

    assessment.getFonarAnswerList().add(answer);

    return FonarAnswerDto.fromEntity(answer);

  }

  // Calculate the total score of assessment

  public Integer calculateTotalScore(Long id){

    FonarAssessment assessment = findById(id);

    if (assessment.getFonarAnswerList() == null){
      throw new NoAnswerWasFilledException("Nenhum resposta foi preenchida!");
    }

    Integer total = assessment.getFonarAnswerList().stream().filter(answer -> answer.getFonarOption() != null).mapToInt(answer ->
    {
      if (answer.getFonarOption().getCritical()){
        return answer.getFonarOption().getScore()*2;
      }

      return answer.getFonarOption().getScore();

    }
    ).sum();

    assessment.setScore(total);

    fonarAssessmentRepository.save(assessment);

    return total;
  }

}

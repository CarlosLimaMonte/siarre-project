package com.projeto.SIARRE.repository;

import com.projeto.SIARRE.entity.FonarAnswer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FonarAnswerRepository extends JpaRepository<FonarAnswer, Long> {


  List<FonarAnswer> findByfonarAssessment_id(Long fonarAssessmentId);

}

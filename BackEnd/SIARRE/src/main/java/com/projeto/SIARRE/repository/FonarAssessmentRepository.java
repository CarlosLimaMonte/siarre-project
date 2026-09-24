package com.projeto.SIARRE.repository;

import com.projeto.SIARRE.entity.FonarAssessment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FonarAssessmentRepository extends JpaRepository<FonarAssessment, Long> {

  List<FonarAssessment> findByVictim_id(Long victimId);

  List<FonarAssessment> findByAggressor_id(Long aggressorId);

}

package com.projeto.SIARRE.repository;

import com.projeto.SIARRE.entity.RelationshipVictimAggressor;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelationshipVictimAggressorRepository extends
    JpaRepository<RelationshipVictimAggressor, Long> {

  List<RelationshipVictimAggressor> findByVictim_id(Long victimId);

  List<RelationshipVictimAggressor> findByAggressor_id(Long aggressorId);

  Boolean existsByVictimIdAndAggressorId(Long victimId, Long aggressorId);
}

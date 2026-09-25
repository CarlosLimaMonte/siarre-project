package com.projeto.SIARRE.repository;

import com.projeto.SIARRE.entity.Aggressor;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AggressorRepository extends JpaRepository<Aggressor, Long> {

  List<Aggressor> findByNameContainingIgnoreCase(String name);

}

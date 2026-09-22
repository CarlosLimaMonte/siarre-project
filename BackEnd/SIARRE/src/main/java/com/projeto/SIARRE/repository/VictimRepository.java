package com.projeto.SIARRE.repository;

import com.projeto.SIARRE.entity.Victim;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VictimRepository extends JpaRepository<Victim, Long> {

  Optional<Victim> findByCpf(String cpf);

  List<Victim> findByNameContainingIgnoreCase(String name);

}

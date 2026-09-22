package com.projeto.SIARRE.service;

import com.projeto.SIARRE.entity.Aggressor;
import com.projeto.SIARRE.entity.dto.AggressorCreateDto;
import com.projeto.SIARRE.entity.dto.AggressorResponseDto;
import com.projeto.SIARRE.exception.AggressorNotFoundException;
import com.projeto.SIARRE.repository.AggressorRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AggressorService {

  private final AggressorRepository aggressorRepository;

  public AggressorService(AggressorRepository aggressorRepository) {
    this.aggressorRepository = aggressorRepository;
  }

  // Create
  public AggressorResponseDto createAggressor(AggressorCreateDto aggressorCreateDto){

    return AggressorResponseDto.fromEntity(aggressorRepository.save(aggressorCreateDto.toEntity()));

  }

  // Read - Find all

  public List<AggressorResponseDto> findAllAggressor(){
    return aggressorRepository.findAll().stream().map(AggressorResponseDto :: fromEntity).toList();
  }

  // Read - FindById

  public Aggressor findAggressorById(Long id){
    return aggressorRepository.findById(id).orElseThrow(
        AggressorNotFoundException::new
    );
  }

  // Update

  public AggressorResponseDto updateAggressorById(Long id, AggressorCreateDto aggressorUpdate){
    Aggressor aggressorFromDb = findAggressorById(id);

    aggressorFromDb.setName(aggressorUpdate.name());
    aggressorFromDb.setSocialName(aggressorUpdate.socialName());
    aggressorFromDb.setDateOfBirth(aggressorUpdate.dateOfBirth());
    aggressorFromDb.setGenderIdentity(aggressorUpdate.genderIdentity());
    aggressorFromDb.setSexualOrientation(aggressorUpdate.sexualOrientation());
    aggressorFromDb.setEducation(aggressorUpdate.education());
    aggressorFromDb.setNationality(aggressorUpdate.nationality());

    return AggressorResponseDto.fromEntity(aggressorRepository.save(aggressorFromDb));

  }

  // Delete
  public void deleteAggressorById(Long id){
    Aggressor aggressorById = findAggressorById(id);

    aggressorRepository.deleteById(id);
  }

  // Find Aggressor by name

  public List<AggressorResponseDto> findAggressorByName(String name){
    return aggressorRepository.findByNameContainingIgnoreCase(name.toLowerCase()).stream().map(AggressorResponseDto :: fromEntity).toList();
  }

}



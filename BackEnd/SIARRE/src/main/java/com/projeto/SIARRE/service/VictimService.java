package com.projeto.SIARRE.service;

import com.projeto.SIARRE.entity.Victim;
import com.projeto.SIARRE.entity.dto.VictimCreateDto;
import com.projeto.SIARRE.entity.dto.VictimResponseDto;
import com.projeto.SIARRE.exception.CpfAlreadyRegisteredException;
import com.projeto.SIARRE.exception.VictimNotFoundException;
import com.projeto.SIARRE.repository.VictimRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class VictimService {

  private final VictimRepository victimRepository;

  public VictimService(VictimRepository victimRepository) {
    this.victimRepository = victimRepository;
  }

  // Create
  public VictimResponseDto createVictim(VictimCreateDto victimCreateDto){

    if(victimRepository.findByCpf(victimCreateDto.cpf()).isEmpty()){
      return VictimResponseDto.fromEntity(victimRepository.save(victimCreateDto.toEntity()));
    } else {
      throw new CpfAlreadyRegisteredException();
    }

  }

  // Read - Find all

  public List<VictimResponseDto> findAllVictims(){
    return victimRepository.findAll().stream().map(VictimResponseDto :: fromEntity).toList();
  }

  // Read - FindById

  public Victim findVictimById(Long id){
    return victimRepository.findById(id).orElseThrow(
        VictimNotFoundException::new
    );
  }

  // Update

  public VictimResponseDto updateVictimById(Long id, VictimCreateDto victimUpdate){
    Victim victimFromDb = findVictimById(id);

    victimFromDb.setName(victimUpdate.name());
    victimFromDb.setSocialName(victimUpdate.socialName());
    victimFromDb.setDateOfBirth(victimUpdate.dateOfBirth());
    victimFromDb.setGenderIdentity(victimUpdate.genderIdentity());
    victimFromDb.setSexualOrientation(victimUpdate.sexualOrientation());
    victimFromDb.setEducation(victimUpdate.education());
    victimFromDb.setNationality(victimUpdate.nationality());

    return VictimResponseDto.fromEntity(victimRepository.save(victimFromDb));

  }

  // Delete
  public void deleteVictimById(Long id){
    Victim victimFromDb = findVictimById(id);

    victimRepository.deleteById(id);
  }

  // Find Victim by CPF

  public VictimResponseDto findVictimByCpf(String cpf){
    return VictimResponseDto.fromEntity(victimRepository.findByCpf(cpf).orElseThrow(
        VictimNotFoundException::new
    ));
  }

  // Find Victim by name

  public List<VictimResponseDto> findVictimByName(String name){
    return victimRepository.findByNameContainingIgnoreCase(name.toLowerCase()).stream().map(VictimResponseDto :: fromEntity).toList();
  }

}



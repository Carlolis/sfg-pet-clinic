package fr.ilieff.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import fr.ilieff.sfgpetclinic.model.PetType;
import fr.ilieff.sfgpetclinic.model.repositories.PetTypeRepository;
import fr.ilieff.sfgpetclinic.services.PetTypeService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {

  private PetTypeRepository petTypeRepository;

  @Override
  public Set<PetType> findAll() {
    Set<PetType> petType = new HashSet<>();

    petTypeRepository.findAll().forEach(petType::add);
    return petType;
  }

  @Override
  public PetType findById(Long id) {
    Optional<PetType> optionalPetType = petTypeRepository.findById(id);

    return optionalPetType.orElse(null);
  }

  @Override
  public PetType save(PetType object) {

    return petTypeRepository.save(object);
  }

  @Override
  public void delete(PetType object) {
    petTypeRepository.delete(object);
  }

  @Override
  public void deleteByID(Long id) {
    petTypeRepository.deleteById(id);
  }


}

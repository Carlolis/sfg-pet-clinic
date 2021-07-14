package fr.ilieff.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import fr.ilieff.sfgpetclinic.model.Pet;
import fr.ilieff.sfgpetclinic.model.repositories.PetRepository;
import fr.ilieff.sfgpetclinic.services.PetService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
@Profile("springdatajpa")
public class PetSDJpaService implements PetService {

  private PetRepository petRepository;

  @Override
  public Set<Pet> findAll() {
    Set<Pet> pet = new HashSet<>();

    petRepository.findAll().forEach(pet::add);
    return pet;
  }

  @Override
  public Pet findById(Long id) {
    Optional<Pet> optionalPet = petRepository.findById(id);

    return optionalPet.orElse(null);
  }

  @Override
  public Pet save(Pet object) {

    return petRepository.save(object);
  }

  @Override
  public void delete(Pet object) {
    petRepository.delete(object);
  }

  @Override
  public void deleteByID(Long id) {
    petRepository.deleteById(id);
  }


}

package fr.ilieff.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import fr.ilieff.sfgpetclinic.model.Vet;
import fr.ilieff.sfgpetclinic.model.repositories.VetRepository;
import fr.ilieff.sfgpetclinic.services.VetService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {

  private VetRepository vetRepository;

  @Override
  public Set<Vet> findAll() {
    Set<Vet> vets = new HashSet<>();

    vetRepository.findAll().forEach(vets::add);
    return vets;
  }

  @Override
  public Vet findById(Long id) {
    Optional<Vet> optionalVet = vetRepository.findById(id);

    return optionalVet.orElse(null);
  }

  @Override
  public Vet save(Vet object) {

    return vetRepository.save(object);
  }

  @Override
  public void delete(Vet object) {
    vetRepository.delete(object);
  }

  @Override
  public void deleteByID(Long id) {
    vetRepository.deleteById(id);
  }

}

package fr.ilieff.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import fr.ilieff.sfgpetclinic.model.Specialty;
import fr.ilieff.sfgpetclinic.model.repositories.SpecialtyRepository;
import fr.ilieff.sfgpetclinic.services.SpecialtyService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
@Profile("springdatajpa")
public class SpecialtySDJpaService implements SpecialtyService {

  private SpecialtyRepository specialtyRepository;

  @Override
  public Set<Specialty> findAll() {
    Set<Specialty> specialty = new HashSet<>();

    specialtyRepository.findAll().forEach(specialty::add);
    return specialty;
  }

  @Override
  public Specialty findById(Long id) {
    Optional<Specialty> optionalSpecialty = specialtyRepository.findById(id);

    return optionalSpecialty.orElse(null);
  }

  @Override
  public Specialty save(Specialty object) {

    return specialtyRepository.save(object);
  }

  @Override
  public void delete(Specialty object) {
    specialtyRepository.delete(object);
  }

  @Override
  public void deleteByID(Long id) {
    specialtyRepository.deleteById(id);
  }


}

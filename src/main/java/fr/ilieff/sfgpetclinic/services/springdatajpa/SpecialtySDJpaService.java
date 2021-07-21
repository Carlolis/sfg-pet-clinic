package fr.ilieff.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import fr.ilieff.sfgpetclinic.model.Speciality;
import fr.ilieff.sfgpetclinic.model.repositories.SpecialtyRepository;
import fr.ilieff.sfgpetclinic.services.SpecialtyService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
@Profile("springdatajpa")
public class SpecialtySDJpaService implements SpecialtyService {

  private SpecialtyRepository specialtyRepository;

  @Override
  public Set<Speciality> findAll() {
    Set<Speciality> specialty = new HashSet<>();

    specialtyRepository.findAll().forEach(specialty::add);
    return specialty;
  }

  @Override
  public Speciality findById(Long id) {
    Optional<Speciality> optionalSpecialty = specialtyRepository.findById(id);

    return optionalSpecialty.orElse(null);
  }

  @Override
  public Speciality save(Speciality object) {

    return specialtyRepository.save(object);
  }

  @Override
  public void delete(Speciality object) {
    specialtyRepository.delete(object);
  }

  @Override
  public void deleteByID(Long id) {
    specialtyRepository.deleteById(id);
  }


}

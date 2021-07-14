package fr.ilieff.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import fr.ilieff.sfgpetclinic.model.Visit;
import fr.ilieff.sfgpetclinic.model.repositories.VisitRepository;
import fr.ilieff.sfgpetclinic.services.VisitService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
@Profile("springdatajpa")
public class VisitSDJpaService implements VisitService {



  private final VisitRepository visitRepository;

  @Override
  public Set<Visit> findAll() {
    Set<Visit> visits = new HashSet<>();

    visitRepository.findAll().forEach(visits::add);
    return visits;
  }

  @Override
  public Visit findById(Long id) {
    Optional<Visit> optionalOwner = visitRepository.findById(id);

    // if (optionalOwner.isPresent()) {
    // return optionalOwner.get();
    // }
    return optionalOwner.orElse(null);
  }

  @Override
  public Visit save(Visit object) {

    return visitRepository.save(object);
  }

  @Override
  public void delete(Visit object) {
    visitRepository.delete(object);

  }

  @Override
  public void deleteByID(Long id) {
    visitRepository.deleteById(id);

  }


}

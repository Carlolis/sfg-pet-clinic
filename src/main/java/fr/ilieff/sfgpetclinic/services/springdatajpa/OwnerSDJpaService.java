package fr.ilieff.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import fr.ilieff.sfgpetclinic.model.Owner;
import fr.ilieff.sfgpetclinic.model.repositories.OwnerRepository;
import fr.ilieff.sfgpetclinic.services.OwnerService;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

  private final OwnerRepository ownerRepository;

  @Override
  public Set<Owner> findAll() {
    return ownerRepository.findAll().stream().collect(Collectors.toSet());
  }

  @Override
  public Set<Owner> findAllByLastNameLike(String lastName) {
    Set<Owner> owners = new HashSet<>();
    ownerRepository.findAllByLastNameLike("%" + lastName + "%").forEach(owners::add);
    return owners;
  }

  @Override
  public Owner findById(Long id) {
    Optional<Owner> optionalOwner = ownerRepository.findById(id);
    return optionalOwner.orElse(null);
  }

  @Override
  public Owner save(Owner object) {
    return ownerRepository.save(object);
  }

  @Override
  public void delete(Owner object) {
    ownerRepository.delete(object);

  }

  @Override
  public void deleteByID(Long id) {
    ownerRepository.deleteById(id);

  }

  @Override
  public Owner findByLastName(String lastName) {

    return ownerRepository.findByLastName(lastName);
  }
}

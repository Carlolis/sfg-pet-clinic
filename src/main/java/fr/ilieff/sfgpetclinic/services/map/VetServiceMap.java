package fr.ilieff.sfgpetclinic.services.map;

import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import fr.ilieff.sfgpetclinic.model.Specialty;
import fr.ilieff.sfgpetclinic.model.Vet;
import fr.ilieff.sfgpetclinic.services.SpecialtyService;
import fr.ilieff.sfgpetclinic.services.VetService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Profile({"default", "map"})
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

  private final SpecialtyService specialityService;

  @Override
  public Vet save(Vet object) {
    if (object.getSpecialities().isEmpty()) {
      object.getSpecialities().forEach(speciality -> {
        if (speciality.getId() == null) {
          Specialty savedSpeciality = specialityService.save(speciality);
          speciality.setId(savedSpeciality.getId());
        }

      });
    }
    return super.save(object);
  }

  @Override
  public Set<Vet> findAll() {
    return super.findAll();
  }

  @Override
  public Vet findById(Long id) {
    return super.findById(id);
  }



  @Override
  public void delete(Vet vet) {
    super.delete(vet);
  }

  @Override
  public void deleteByID(Long id) {
    super.deleteByID(id);
  }

}

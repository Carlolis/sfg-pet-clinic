package fr.ilieff.sfgpetclinic.services.map;

import java.util.Set;
import org.springframework.stereotype.Service;
import fr.ilieff.sfgpetclinic.model.Speciality;
import fr.ilieff.sfgpetclinic.model.Vet;
import fr.ilieff.sfgpetclinic.services.SpecialityService;
import fr.ilieff.sfgpetclinic.services.VetService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

  private final SpecialityService specialityService;

  @Override
  public Vet save(Vet object) {
    if (object.getSpecialities().isEmpty()) {
      object.getSpecialities().forEach(speciality -> {
        if (speciality.getId() == null) {
          Speciality savedSpeciality = specialityService.save(speciality);
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

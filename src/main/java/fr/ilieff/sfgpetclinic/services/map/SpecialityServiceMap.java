package fr.ilieff.sfgpetclinic.services.map;

import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import fr.ilieff.sfgpetclinic.model.Speciality;
import fr.ilieff.sfgpetclinic.services.SpecialtyService;

@Service
@Profile({"default", "map"})
public class SpecialityServiceMap extends AbstractMapService<Speciality, Long>
    implements SpecialtyService {

  @Override
  public Speciality save(Speciality speciality) {
    return super.save(speciality);
  }

  @Override
  public Set<Speciality> findAll() {
    return super.findAll();
  }

  @Override
  public Speciality findById(Long id) {
    return super.findById(id);
  }



  @Override
  public void delete(Speciality speciality) {
    super.delete(speciality);
  }

  @Override
  public void deleteByID(Long id) {
    super.deleteByID(id);
  }
}

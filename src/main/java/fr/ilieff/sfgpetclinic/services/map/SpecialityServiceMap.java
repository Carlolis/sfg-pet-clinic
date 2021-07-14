package fr.ilieff.sfgpetclinic.services.map;

import java.util.Set;
import org.springframework.stereotype.Service;
import fr.ilieff.sfgpetclinic.model.Specialty;
import fr.ilieff.sfgpetclinic.services.SpecialtyService;

@Service
public class SpecialityServiceMap extends AbstractMapService<Specialty, Long>
    implements SpecialtyService {

  @Override
  public Specialty save(Specialty speciality) {
    return super.save(speciality);
  }

  @Override
  public Set<Specialty> findAll() {
    return super.findAll();
  }

  @Override
  public Specialty findById(Long id) {
    return super.findById(id);
  }



  @Override
  public void delete(Specialty speciality) {
    super.delete(speciality);
  }

  @Override
  public void deleteByID(Long id) {
    super.deleteByID(id);
  }
}

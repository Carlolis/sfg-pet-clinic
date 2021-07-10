package fr.ilieff.sfgpetclinic.services.map;

import java.util.Set;
import fr.ilieff.sfgpetclinic.model.Speciality;

import fr.ilieff.sfgpetclinic.services.SpecialitiesService;

public class SpecialitiesServiceMap extends AbstractMapService<Speciality, Long>
    implements SpecialitiesService {

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

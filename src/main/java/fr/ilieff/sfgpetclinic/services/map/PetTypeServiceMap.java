package fr.ilieff.sfgpetclinic.services.map;

import java.util.Set;
import org.springframework.stereotype.Service;
import fr.ilieff.sfgpetclinic.model.PetType;
import fr.ilieff.sfgpetclinic.services.PetTypeService;

@Service
public class PetTypeServiceMap extends AbstractMapService<PetType, Long> implements PetTypeService {

  @Override
  public PetType findById(Long id) {

    return super.findById(id);
  }


  @Override
  public PetType save(PetType object) {

    return super.save(object);
  }

  @Override
  public void delete(PetType object) {
    super.delete(object);

  }

  @Override
  public void deleteByID(Long id) {
    super.deleteByID(id);
  }

  @Override
  public Set<PetType> findAll() {
    return super.findAll();
  }



}

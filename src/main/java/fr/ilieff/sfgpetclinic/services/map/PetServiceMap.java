package fr.ilieff.sfgpetclinic.services.map;

import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import fr.ilieff.sfgpetclinic.model.Pet;
import fr.ilieff.sfgpetclinic.services.PetService;

@Service
@Profile({"default", "map"})
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

  @Override
  public Pet save(Pet object) {
    return super.save(object);
  }

  @Override
  public Set<Pet> findAll() {
    return super.findAll();
  }

  @Override
  public Pet findById(Long id) {
    return super.findById(id);
  }



  @Override
  public void delete(Pet pet) {
    super.delete(pet);
  }

  @Override
  public void deleteByID(Long id) {
    super.deleteByID(id);
  }

}

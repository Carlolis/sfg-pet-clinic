package fr.ilieff.sfgpetclinic.services.map;

import java.util.Set;
import fr.ilieff.sfgpetclinic.model.Pet;
import fr.ilieff.sfgpetclinic.services.CrudService;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements CrudService<Pet, Long> {

  @Override
  public Pet save(Pet object) {
    return this.save(object.getId(), object);
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

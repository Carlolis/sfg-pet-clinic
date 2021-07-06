package fr.ilieff.sfgpetclinic.services.map;

import java.util.Set;
import fr.ilieff.sfgpetclinic.model.Owner;
import fr.ilieff.sfgpetclinic.services.CrudService;

public class OwnerServiceMap extends AbstractMapService<Owner, Long>
    implements CrudService<Owner, Long> {

  @Override
  public Owner save(Owner object) {
    return this.save(object.getId(), object);
  }

  @Override
  public Set<Owner> findAll() {
    return super.findAll();
  }

  @Override
  public Owner findById(Long id) {
    return super.findById(id);
  }



  @Override
  public void delete(Owner owner) {
    super.delete(owner);
  }

  @Override
  public void deleteByID(Long id) {
    super.deleteByID(id);
  }

}

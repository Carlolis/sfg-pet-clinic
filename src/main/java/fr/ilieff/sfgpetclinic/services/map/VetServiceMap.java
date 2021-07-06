package fr.ilieff.sfgpetclinic.services.map;

import java.util.Set;
import fr.ilieff.sfgpetclinic.model.Vet;
import fr.ilieff.sfgpetclinic.services.CrudService;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements CrudService<Vet, Long> {

  @Override
  public Vet save(Vet object) {
    return this.save(object.getId(), object);
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

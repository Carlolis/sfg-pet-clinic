package fr.ilieff.sfgpetclinic.services.map;

import java.util.Set;
import org.springframework.stereotype.Service;
import fr.ilieff.sfgpetclinic.model.Vet;
import fr.ilieff.sfgpetclinic.services.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

  @Override
  public Vet save(Vet object) {
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

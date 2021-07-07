package fr.ilieff.sfgpetclinic.services.map;

import java.util.Set;
import org.springframework.stereotype.Service;
import fr.ilieff.sfgpetclinic.model.Owner;
import fr.ilieff.sfgpetclinic.services.OwnerService;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

  @Override
  public Owner save(Owner object) {
    return super.save(object);
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

  @Override
  public Owner findByLastName(String lastName) {
    // TODO Auto-generated method stub
    return null;
  }

}

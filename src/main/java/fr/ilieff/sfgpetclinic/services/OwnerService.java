package fr.ilieff.sfgpetclinic.services;

import java.util.List;
import fr.ilieff.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {


  Owner findByLastName(String lastName);

  List<Owner> findAllByLastNameLike(String lastName);
}

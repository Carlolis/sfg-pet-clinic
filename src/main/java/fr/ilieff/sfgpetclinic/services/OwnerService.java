package fr.ilieff.sfgpetclinic.services;

import java.util.Set;
import fr.ilieff.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

  Owner findByLastName(String lastName);

  Set<Owner> findAllByLastNameLike(String lastName);
}

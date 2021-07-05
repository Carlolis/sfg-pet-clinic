package fr.ilieff.sfgpetclinic.services;

import fr.ilieff.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {


  Owner findByLastName(String lastName);


}

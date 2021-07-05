package fr.ilieff.sfgpetclinic.services;

import java.util.Set;
import fr.ilieff.sfgpetclinic.model.Pet;

public interface PetService {

  Pet findById(Long id);

  Pet save(Pet pet);

  Set<Pet> findAll();
}

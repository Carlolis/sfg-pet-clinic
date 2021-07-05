package fr.ilieff.sfgpetclinic.services;

import java.util.Set;
import fr.ilieff.sfgpetclinic.model.Pet;

public interface VetService {

  Pet findById(Long id);

  Pet save(Pet vet);

  Set<Pet> findAll();
}

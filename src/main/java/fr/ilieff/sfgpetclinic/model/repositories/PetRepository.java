package fr.ilieff.sfgpetclinic.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.ilieff.sfgpetclinic.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {

}

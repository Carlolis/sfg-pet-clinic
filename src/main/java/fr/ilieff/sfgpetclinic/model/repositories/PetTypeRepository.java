package fr.ilieff.sfgpetclinic.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.ilieff.sfgpetclinic.model.PetType;

public interface PetTypeRepository extends JpaRepository<PetType, Long> {

}

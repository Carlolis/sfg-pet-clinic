package fr.ilieff.sfgpetclinic.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.ilieff.sfgpetclinic.model.Specialty;

public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {

}

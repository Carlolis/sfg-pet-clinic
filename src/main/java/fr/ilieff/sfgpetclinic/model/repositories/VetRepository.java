package fr.ilieff.sfgpetclinic.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.ilieff.sfgpetclinic.model.Vet;

public interface VetRepository extends JpaRepository<Vet, Long> {

}

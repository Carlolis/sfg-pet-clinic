package fr.ilieff.sfgpetclinic.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.ilieff.sfgpetclinic.model.Visit;

public interface VisitRepository extends JpaRepository<Visit, Long> {
}

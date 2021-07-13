package fr.ilieff.sfgpetclinic.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fr.ilieff.sfgpetclinic.model.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
}

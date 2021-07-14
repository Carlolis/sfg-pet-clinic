package fr.ilieff.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Specialty extends BaseEntity {

  @ManyToMany
  private Set<Vet> specialities = new HashSet<>();

  private String description;
}

package fr.ilieff.sfgpetclinic.model;

import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Speciality extends BaseEntity {
  private String description;
}

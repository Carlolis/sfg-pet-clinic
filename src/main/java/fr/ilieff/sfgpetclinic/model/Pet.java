package fr.ilieff.sfgpetclinic.model;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class Pet extends BaseEntity {

  private String name;
  private LocalDate birthDate;
  private PetType petType;
  private Owner owner;
}

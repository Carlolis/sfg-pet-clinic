package fr.ilieff.sfgpetclinic.model;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pet {
  private LocalDate birthDate;
  private PetType petType;
  private Owner owner;
}

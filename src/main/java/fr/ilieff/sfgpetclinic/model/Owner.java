package fr.ilieff.sfgpetclinic.model;

import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Owner extends Person {

  private String city;
  private String adresse;
  private String telephone;
  private Set<Pet> pets;

}

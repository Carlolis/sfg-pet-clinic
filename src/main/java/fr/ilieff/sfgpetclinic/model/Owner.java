package fr.ilieff.sfgpetclinic.model;

import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Owner extends Person {

  private String city;
  private String adresse;
  private String telephone;
  private Set<Pet> pets;

  @Override
  public String toString() {
    return "Owner [" + super.getFirstName() + " adresse=" + adresse + ", city=" + city + ", pets="
        + pets + ", telephone=" + telephone + "]";
  }

}

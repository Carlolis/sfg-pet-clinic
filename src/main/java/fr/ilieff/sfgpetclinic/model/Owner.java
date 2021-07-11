package fr.ilieff.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "owners")
public class Owner extends Person {

  private String city;
  private String adresse;
  private String telephone;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
  private Set<Pet> pets = new HashSet<>();

  @Override
  public String toString() {
    return "Owner [" + super.getFirstName() + " adresse=" + adresse + ", city=" + city + ", pets="
        + pets + ", telephone=" + telephone + "]";
  }

}

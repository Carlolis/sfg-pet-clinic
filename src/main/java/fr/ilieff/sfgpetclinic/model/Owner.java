package fr.ilieff.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "owners")
public class Owner extends Person {

  private String city;
  private String address;
  private String telephone;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
  private Set<Pet> pets = new HashSet<>();


  @Builder
  public Owner(String firstName, String lastName, String city, String address, String telephone,
      Set<Pet> pets, Long id) {
    super(id, firstName, lastName);
    this.city = city;
    this.address = address;
    this.telephone = telephone;
    this.pets = pets;
  }

  public Owner(String city, String address, String telephone, Set<Pet> pets) {
    this.city = city;
    this.address = address;
    this.telephone = telephone;
    this.pets = pets;
  }



  @Override
  public String toString() {
    return "Owner [" + super.getFirstName() + " address=" + address + ", city=" + city + ", pets="
        + pets + ", telephone=" + telephone + "]";
  }

}

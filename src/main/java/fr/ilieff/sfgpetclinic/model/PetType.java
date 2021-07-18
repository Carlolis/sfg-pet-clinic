package fr.ilieff.sfgpetclinic.model;


import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class PetType extends BaseEntity {


  private String name;

  @Override
  public String toString() {
    return name;
  }



}

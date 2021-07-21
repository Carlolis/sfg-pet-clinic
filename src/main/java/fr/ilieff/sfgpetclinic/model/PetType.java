package fr.ilieff.sfgpetclinic.model;


import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PetType extends BaseEntity {

  @Builder
  public PetType(Long id, String name) {
    super(id);
    this.name = name;
  }

  private String name;

  @Override
  public String toString() {
    return name;
  }



}

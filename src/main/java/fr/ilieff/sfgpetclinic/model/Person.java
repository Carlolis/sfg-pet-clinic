package fr.ilieff.sfgpetclinic.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@MappedSuperclass
public class Person extends BaseEntity {


  public Person(Long id, String firstName, String lastName) {
    super(id);
    this.firstName = firstName;
    this.lastName = lastName;
  }

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

}

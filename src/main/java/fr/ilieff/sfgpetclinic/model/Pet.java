package fr.ilieff.sfgpetclinic.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {


  @Builder
  public Pet(Long id, String name, LocalDate birthDate, PetType petType, Owner owner,
      Set<Visit> visits) {
    super(id);
    this.name = name;
    this.birthDate = birthDate;
    this.petType = petType;
    this.owner = owner;
    if (visits == null || visits.isEmpty()) {
      this.visits = visits;
    }

  }

  private String name;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate birthDate;

  @ManyToOne
  @JoinColumn(name = "type_id")
  private PetType petType;

  @ManyToOne
  @JoinColumn(name = "owner_id")
  private Owner owner;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
  private Set<Visit> visits = new HashSet<>();



}

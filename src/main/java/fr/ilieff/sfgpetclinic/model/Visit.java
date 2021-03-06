package fr.ilieff.sfgpetclinic.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Visit extends BaseEntity {

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate date;
  private String description;

  @ManyToOne
  @JoinColumn(name = "pet_id")
  private Pet pet;
}

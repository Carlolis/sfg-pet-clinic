package fr.ilieff.sfgpetclinic.bootstrap;

import java.time.LocalDate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import fr.ilieff.sfgpetclinic.model.Owner;
import fr.ilieff.sfgpetclinic.model.Pet;
import fr.ilieff.sfgpetclinic.model.PetType;
import fr.ilieff.sfgpetclinic.model.Speciality;
import fr.ilieff.sfgpetclinic.model.Vet;
import fr.ilieff.sfgpetclinic.model.Visit;
import fr.ilieff.sfgpetclinic.services.OwnerService;
import fr.ilieff.sfgpetclinic.services.PetService;
import fr.ilieff.sfgpetclinic.services.PetTypeService;
import fr.ilieff.sfgpetclinic.services.SpecialtyService;
import fr.ilieff.sfgpetclinic.services.VetService;
import fr.ilieff.sfgpetclinic.services.VisitService;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {

  private final OwnerService ownerService;

  private final VetService vetService;

  private final PetService petService;

  private final PetTypeService petTypeService;

  private final SpecialtyService specialityService;

  private final VisitService visitService;



  @Override
  public void run(String... args) throws Exception {

    if (petTypeService.findAll().isEmpty()) {

      loadDatat();
    }
  }



  private void loadDatat() {


    var radiology = new Speciality();
    radiology.setDescription("Radiology");
    specialityService.save(radiology);

    var surgery = new Speciality();
    surgery.setDescription("Surgery");
    specialityService.save(surgery);

    var dentistry = new Speciality();
    dentistry.setDescription("Dentistry");
    specialityService.save(dentistry);

    System.out.println("Loaded Specialities...");



    var dog = new PetType();
    dog.setName("Dog");

    PetType savedDog = petTypeService.save(dog);

    var cat = new PetType();
    cat.setName("Cat");

    petTypeService.save(cat);

    System.out.println("Loaded PetType...");


    var owner1 = new Owner();

    owner1.setLastName("Robert");
    owner1.setFirstName("Weston");
    owner1.setAddress("123 Brickerel");
    owner1.setCity("Paris");
    ownerService.save(owner1);


    var robertPet = new Pet();
    robertPet.setPetType(savedDog);
    robertPet.setOwner(owner1);
    robertPet.setName("Rococo");
    robertPet.setBirthDate(LocalDate.now());
    petService.save(robertPet);
    owner1.getPets().add(robertPet);

    var owner2 = new Owner();

    owner2.setLastName("Fiona");
    owner2.setFirstName("Glenanne");
    owner2.setAddress("123 place du Capitole");
    owner2.setCity("Toulouse");
    ownerService.save(owner2);



    var fionaPet = new Pet();
    fionaPet.setPetType(cat);
    fionaPet.setOwner(owner2);
    fionaPet.setName("Ratenplin");
    fionaPet.setBirthDate(LocalDate.now());

    petService.save(fionaPet);

    var catVisit = new Visit();
    catVisit.setPet(fionaPet);
    catVisit.setDate(LocalDate.now());
    catVisit.setDescription("Visite du chat pour problémes.");



    owner2.getPets().add(fionaPet);

    visitService.save(catVisit);

    var owner3 = new Owner();
    // Owner.builder().lastName("Bob").firstName("Kennedy").address("12 rue Gégé")
    // .city("Carcassonne").build();
    owner3.setLastName("Bob");
    owner3.setFirstName("Kennedy");
    owner3.setAddress("12 rue Gégé");
    owner3.setCity("Carcassonne");


    ownerService.save(owner3);

    var bobPet = new Pet();
    bobPet.setPetType(dog);
    bobPet.setOwner(owner3);
    bobPet.setName("Coca");
    bobPet.setBirthDate(LocalDate.now());

    owner3.getPets().add(bobPet);


    System.out.println("Loaded Owners...");


    var vet1 = new Vet();

    vet1.setLastName("Michael");
    vet1.setFirstName("Weston");
    vet1.getSpecialities().add(radiology);
    vetService.save(vet1);


    var vet2 = new Vet();

    vet2.setLastName("Marcel");
    vet2.setFirstName("Jackson");
    vet2.getSpecialities().add(dentistry);
    vetService.save(vet2);

    System.out.println("Loaded Vets...");
  }

}

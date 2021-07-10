package fr.ilieff.sfgpetclinic.bootstrap;

import java.time.LocalDate;
import java.util.Set;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import fr.ilieff.sfgpetclinic.model.Owner;
import fr.ilieff.sfgpetclinic.model.Pet;
import fr.ilieff.sfgpetclinic.model.PetType;
import fr.ilieff.sfgpetclinic.model.Vet;
import fr.ilieff.sfgpetclinic.services.OwnerService;
import fr.ilieff.sfgpetclinic.services.PetTypeService;
import fr.ilieff.sfgpetclinic.services.VetService;



@Component
public class DataLoader implements CommandLineRunner {

  private final OwnerService ownerService;

  private final VetService vetService;

  private final PetTypeService petTypeService;



  public DataLoader(OwnerService ownerService, VetService vetService,
      PetTypeService petTypeService) {
    this.ownerService = ownerService;
    this.vetService = vetService;
    this.petTypeService = petTypeService;
  }



  @Override
  public void run(String... args) throws Exception {

    var dog = new PetType();
    dog.setName("Dog");

    PetType dogSaved = petTypeService.save(dog);

    var cat = new PetType();
    dog.setName("Cat");

    PetType catSaved = petTypeService.save(cat);

    System.out.println("Loaded PetType...");


    var owner1 = new Owner();

    owner1.setLastName("Robert");
    owner1.setFirstName("Weston");
    owner1.setAdresse("123 Brickerel");
    owner1.setCity("Paris");
    ownerService.save(owner1);
    var robertPet = new Pet();
    robertPet.setPetType(dogSaved);
    robertPet.setOwner(owner1);
    robertPet.setName("Rococo");
    robertPet.setBirthDate(LocalDate.now());
    owner1.getPets().add(robertPet);

    var owner2 = new Owner();

    owner2.setLastName("Fiona");
    owner2.setFirstName("Glenanne");
    owner2.setAdresse("123 place du Capitole");
    owner2.setCity("Toulouse");
    ownerService.save(owner2);
    var fionaPet = new Pet();
    fionaPet.setPetType(catSaved);
    fionaPet.setOwner(owner2);
    fionaPet.setName("Ratenplin");
    fionaPet.setBirthDate(LocalDate.now());


    owner2.setPets(Set.of(fionaPet));
    // owner2.getPets().add(fionaPet);


    var owner3 = new Owner();

    owner3.setLastName("Bob");
    owner3.setFirstName("Kennedy");
    owner3.setAdresse("12 rue Gégé");
    owner3.setCity("Carcassonne");
    ownerService.save(owner3);

    var bobPet = new Pet();
    bobPet.setPetType(dogSaved);
    bobPet.setOwner(owner3);
    bobPet.setName("Coca");
    bobPet.setBirthDate(LocalDate.now());

    owner3.getPets().add(bobPet);

    ownerService.findAll().forEach(System.out::println);
    System.out.println("Loaded Owners...");


    var vet1 = new Vet();

    vet1.setLastName("Michael");
    vet1.setFirstName("Weston");
    vetService.save(vet1);


    var vet2 = new Vet();

    vet2.setLastName("Michael");
    vet2.setFirstName("Jackson");
    vetService.save(vet2);

    System.out.println("Loaded Vets...");


  }

}

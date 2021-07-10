package fr.ilieff.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import fr.ilieff.sfgpetclinic.model.Owner;
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

    petTypeService.save(dog);

    var cat = new PetType();
    dog.setName("Cat");

    petTypeService.save(cat);

    System.out.println("Loaded PetType...");


    var owner1 = new Owner();

    owner1.setLastName("Robert");
    owner1.setFirstName("Weston");
    ownerService.save(owner1);

    var owner2 = new Owner();

    owner2.setLastName("Fiona");
    owner2.setFirstName("Glenanne");
    ownerService.save(owner2);


    var owner3 = new Owner();

    owner3.setLastName("Bob");
    owner3.setFirstName("Kennedy");
    ownerService.save(owner3);

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

package fr.ilieff.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import fr.ilieff.sfgpetclinic.model.Owner;
import fr.ilieff.sfgpetclinic.model.Vet;
import fr.ilieff.sfgpetclinic.services.OwnerService;
import fr.ilieff.sfgpetclinic.services.VetService;



@Component
public class DataLoader implements CommandLineRunner {

  private final OwnerService ownerService;

  private final VetService vetService;



  public DataLoader(OwnerService ownerService, VetService vetService) {
    this.ownerService = ownerService;
    this.vetService = vetService;
  }



  @Override
  public void run(String... args) throws Exception {

    var owner1 = new Owner();
    owner1.setId(1L);
    owner1.setLastName("Robert");
    owner1.setFirstName("Weston");
    ownerService.save(owner1);

    var owner2 = new Owner();
    owner2.setId(2L);
    owner2.setLastName("Fiona");
    owner2.setFirstName("Glenanne");
    ownerService.save(owner2);


    var owner3 = new Owner();
    owner3.setId(3L);
    owner3.setLastName("Bob");
    owner3.setFirstName("Kennedy");
    ownerService.save(owner3);

    System.out.println(ownerService.findAll());
    System.out.println("Loaded Owners...");


    var vet1 = new Vet();
    vet1.setId(1L);
    vet1.setLastName("Michael");
    vet1.setFirstName("Weston");
    vetService.save(vet1);


    var vet2 = new Vet();
    vet2.setId(2L);
    vet2.setLastName("Michael");
    vet2.setFirstName("Jackson");
    vetService.save(vet2);

    System.out.println("Loaded Vets...");
  }

}

package fr.ilieff.sfgpetclinic.controllers;

import java.util.Collection;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import fr.ilieff.sfgpetclinic.model.Owner;
import fr.ilieff.sfgpetclinic.model.PetType;
import fr.ilieff.sfgpetclinic.services.OwnerService;
import fr.ilieff.sfgpetclinic.services.PetService;
import fr.ilieff.sfgpetclinic.services.PetTypeService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {


  private final PetService petService;
  private final OwnerService ownerService;
  private final PetTypeService petTypeService;


  @ModelAttribute("types")
  public Collection<PetType> popularPetTypes() {
    return this.petTypeService.findAll();
  }


  @ModelAttribute("owner")
  public Owner findOwner(@PathVariable("ownerId") Long ownerId) {
    return this.ownerService.findById(ownerId);
  }

  @InitBinder("owner")
  public void initOwnerBinder(WebDataBinder dataBinder) {
    dataBinder.setDisallowedFields("id");
  }
}

package fr.ilieff.sfgpetclinic.controllers;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import fr.ilieff.sfgpetclinic.model.Visit;
import fr.ilieff.sfgpetclinic.services.PetService;
import fr.ilieff.sfgpetclinic.services.VisitService;

@Controller
class VisitController {

  private final VisitService visitService;

  private final PetService petService;

  public VisitController(VisitService visitService, PetService petService) {
    this.visitService = visitService;
    this.petService = petService;
  }

  @InitBinder
  public void setAllowedFields(WebDataBinder dataBinder) {
    dataBinder.setDisallowedFields("id");
  }

  @InitBinder("visit")
  public void initOwnerBinder(WebDataBinder dataBinder) {
    var dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    dataBinder.registerCustomEditor(LocalDate.class, new CustomDateEditor(dateFormat, true));
  }

  @ModelAttribute("visit")
  public Visit loadPetWithVisit(@PathVariable("petId") Long petId, Model model) {
    var pet = this.petService.findById(petId);
    model.addAttribute("pet", pet);
    var visit = new Visit();
    visit.setPet(pet);
    pet.getVisits().add(visit);
    return visit;
  }

  // Spring MVC calls method loadPetWithVisit(...) before initNewVisitForm is called
  @GetMapping("/owners/*/pets/{petId}/visits/new")
  public String initNewVisitForm(@PathVariable("petId") Long petId, Model model) {
    return "pets/createOrUpdateVisitForm";
  }

  // Spring MVC calls method loadPetWithVisit(...) before processNewVisitForm is called
  @PostMapping("/owners/{ownerId}/pets/{petId}/visits/new")
  public String processNewVisitForm(@Validated Visit visit, BindingResult result) {



    if (result.hasErrors()) {
      return "pets/createOrUpdateVisitForm";
    } else {
      this.visitService.save(visit);
      return "redirect:/owners/{ownerId}";
    }
  }

}

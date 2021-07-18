package fr.ilieff.sfgpetclinic.services.map;

import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import fr.ilieff.sfgpetclinic.model.Owner;
import fr.ilieff.sfgpetclinic.model.Pet;
import fr.ilieff.sfgpetclinic.services.OwnerService;
import fr.ilieff.sfgpetclinic.services.PetService;
import fr.ilieff.sfgpetclinic.services.PetTypeService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Profile({"default", "map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {


  private final PetTypeService petTypeService;
  private final PetService petService;

  @Override
  public Owner save(Owner object) {

    if (object != null) {
      if (object.getPets() != null) {
        object.getPets().forEach(pet -> {
          if (pet.getPetType().getId() == null) {
            pet.setPetType(petTypeService.save(pet.getPetType()));
          } else {
            throw new RuntimeException("Pet Type is required");
          }
          if (pet.getId() == null) {
            Pet savedPet = petService.save(pet);
            pet.setId(savedPet.getId());
          }
        });
      }
      return super.save(object);
    } else {
      return null;
    }

  }

  @Override
  public Set<Owner> findAll() {
    return super.findAll();
  }

  @Override
  public Owner findById(Long id) {
    return super.findById(id);
  }



  @Override
  public void delete(Owner owner) {
    super.delete(owner);
  }

  @Override
  public void deleteByID(Long id) {
    super.deleteByID(id);
  }

  @Override
  public Owner findByLastName(String lastName) {

    return this.findAll().stream().filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
        .findFirst().orElse(null);
  }

}

package fr.ilieff.sfgpetclinic.services.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import fr.ilieff.sfgpetclinic.model.Owner;

class OwnerServiceMapTest {

  OwnerServiceMap ownerMapService;

  final Long ownerId = 1L;
  final String lastName = "Robert";

  @BeforeEach
  void setUp() {
    ownerMapService = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
    ownerMapService.save(Owner.builder().id(ownerId).lastName(lastName).build());
  }

  @Test
  void testDelete() {
    ownerMapService.delete(ownerMapService.findById(ownerId));
    assertEquals(0, ownerMapService.findAll().size());
  }

  @Test
  void testDeleteByID() {
    ownerMapService.deleteByID(ownerMapService.findById(ownerId).getId());
    assertEquals(0, ownerMapService.findAll().size());
  }

  @Test
  void testFindAll() {
    Set<Owner> ownerSet = ownerMapService.findAll();
    assertEquals(1, ownerSet.size());
  }

  @Test
  void testFindById() {
    Owner owner = ownerMapService.findById(ownerId);
    assertEquals(ownerId, owner.getId());
  }

  @Test
  void testFindByLastName() {
    Owner owner = ownerMapService.findByLastName(lastName);
    assertNotNull(owner);
    assertEquals(ownerId, owner.getId());
  }

  @Test
  void testFindByLastNameNotFound() {
    Owner owner = ownerMapService.findByLastName("foo");

    assertNull(owner);
  }

  @Test
  void testSaveExistingId() {
    Long id = 2L;
    Owner owner2 = Owner.builder().id(id).build();
    Owner savedOwner = ownerMapService.save(owner2);
    assertEquals(id, savedOwner.getId());
  }


  @Test
  void testSaveNoId() {
    Owner savedOwner = ownerMapService.save(Owner.builder().build());
    assertNotNull(savedOwner);
    assertNotNull(savedOwner.getId());
  }
}

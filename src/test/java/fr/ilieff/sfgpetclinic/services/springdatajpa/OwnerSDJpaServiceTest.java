package fr.ilieff.sfgpetclinic.services.springdatajpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import fr.ilieff.sfgpetclinic.model.Owner;
import fr.ilieff.sfgpetclinic.model.repositories.OwnerRepository;
import fr.ilieff.sfgpetclinic.model.repositories.PetRepository;
import fr.ilieff.sfgpetclinic.model.repositories.PetTypeRepository;


@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

  @Mock
  OwnerRepository ownerRepository;

  @Mock
  PetRepository petRepository;

  @Mock
  PetTypeRepository petTypeRepository;


  @InjectMocks
  OwnerSDJpaService service;


  Owner returnOwner;


  @BeforeEach
  void setUp() {
    returnOwner = Owner.builder().id(1L).lastName("Smith").build();
  }

  @Test
  void testDelete() {

  }

  @Test
  void testDeleteByID() {

  }

  @Test
  void testFindAll() {
    List<Owner> returnOwnersSet = new ArrayList<>();

    returnOwnersSet.add(Owner.builder().id(1L).build());
    returnOwnersSet.add(Owner.builder().id(2L).build());

    when(ownerRepository.findAll()).thenReturn(returnOwnersSet);

    Set<Owner> owners = service.findAll();

    assertNotNull(owners);
    assertEquals(2, owners.size());

  }

  @Test
  void testFindById() {
    when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

    Owner owner = service.findById(1L);

    assertNotNull(owner);
  }

  @Test
  void testFindByIdNotFound() {
    when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

    Owner owner = service.findById(1L);

    assertNull(owner);
  }

  @Test
  void testFindByLastName() {

    when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

    Owner smith = service.findByLastName("Smith");

    assertEquals("Smith", smith.getLastName());

    verify(ownerRepository).findByLastName(any());
  }

  @Test
  void testSave() {

  }
}

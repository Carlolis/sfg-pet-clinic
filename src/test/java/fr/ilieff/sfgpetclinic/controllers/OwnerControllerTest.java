package fr.ilieff.sfgpetclinic.controllers;

import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import fr.ilieff.sfgpetclinic.model.Owner;
import fr.ilieff.sfgpetclinic.services.OwnerService;


@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

  @Mock
  OwnerService ownerService;

  @InjectMocks
  OwnerController controller;

  Set<Owner> owners;

  MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    owners = new HashSet<>();
    owners.add(Owner.builder().id(1L).build());
    owners.add(Owner.builder().id(2L).build());
    owners.add(Owner.builder().id(3L).build());
    owners.add(Owner.builder().id(4L).build());

    mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
  }



  @Test
  void testFindOwners() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/owners/find"))
        .andExpect((MockMvcResultMatchers.status().isNotFound()));

  }

  @Test
  void testListOwners() throws Exception {
    when(ownerService.findAll()).thenReturn(owners);
    mockMvc.perform(MockMvcRequestBuilders.get("/owners"))
        .andExpect(MockMvcResultMatchers.status().isOk());


  }


}

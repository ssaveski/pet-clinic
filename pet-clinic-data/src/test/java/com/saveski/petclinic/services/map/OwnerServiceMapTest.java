package com.saveski.petclinic.services.map;


import com.saveski.petclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(),
                new PetServiceMap());

        Owner savedOwner = new Owner();
        savedOwner.setId(1L);
        savedOwner.setLastName("smith");
        ownerServiceMap.save(savedOwner);


    }

    @Test
    void findAll() {

        Set<Owner> ownerSet = ownerServiceMap.findAll();

        assertEquals(1, ownerSet.size());

    }

    @Test
    void findById() {
    }

    @Test
    void saveExistingId() {
        Owner savedOwner2 = new Owner();
        savedOwner2.setId(2L);
        ownerServiceMap.save(savedOwner2);

        assertEquals(2L, savedOwner2.getId());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(1L));
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(1L);
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner smith = ownerServiceMap.findByLastName("smith");
        assertEquals(1L, smith.getId());
    }
}
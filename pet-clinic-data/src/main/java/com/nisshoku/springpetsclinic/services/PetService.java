package com.nisshoku.springpetsclinic.services;

import com.nisshoku.springpetsclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
